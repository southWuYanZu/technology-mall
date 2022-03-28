package com.sxx.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxx.common.constant.WareConstant;
import com.sxx.common.utils.PageUtils;
import com.sxx.common.utils.Query;
import com.sxx.common.utils.ResponseEntity;
import com.sxx.ware.entity.Purchase;
import com.sxx.ware.entity.PurchaseDetail;
import com.sxx.ware.mapper.PurchaseMapper;
import com.sxx.ware.service.PurchaseDetailService;
import com.sxx.ware.service.PurchaseService;
import com.sxx.ware.service.WareSkuService;
import com.sxx.ware.vo.MergeVo;
import com.sxx.ware.vo.PurchaseDoneVo;
import com.sxx.ware.vo.PurchaseItemDoneVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 针对表【wms_purchase(采购信息)】的数据库操作Service实现
 *
 * @author Mr.shen
 * @since 2022-03-27 16:45:54
 */
@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase>
        implements PurchaseService {

    private final WareSkuService wareSkuService;

    private final PurchaseDetailService purchaseDetailService;

    @Override
    public ResponseEntity queryPage(Map<String, Object> params) {
        Query<Purchase> query = new Query<>();
        QueryWrapper<Purchase> wrapper = new QueryWrapper<>();
        IPage<Purchase> page = this.page(query.getPage(params), wrapper);
        return ResponseEntity.ok("page", new PageUtils(page));
    }


    @Override
    public PageUtils queryPageUnReceive(Map<String, Object> params) {

        QueryWrapper<Purchase> queryWrapper = new QueryWrapper<Purchase>()
                .eq("status", 0).or().eq("status", 1);

        IPage<Purchase> page = this.page(
                new Query<Purchase>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void mergePurchase(MergeVo mergeVo) {

        Long purchaseId = mergeVo.getPurchaseId();

        //没有选择任何【采购单】，将自动创建新单进行合并。
        if (purchaseId == null) {
            Purchase purchaseEntity = new Purchase();
            //设置采购单的默认状态
            purchaseEntity.setStatus(WareConstant.PurchaseStatusEnum.CREATED.getCode());

            purchaseEntity.setCreateTime(new Date());
            purchaseEntity.setUpdateTime(new Date());
            this.save(purchaseEntity);

            //获取新建采购单的id
            purchaseId = purchaseEntity.getId();

        }

        List<Long> items = mergeVo.getItems();

        //TODO 确认采购单状态是0,1才可以合并
        Collection<PurchaseDetail> purchaseDetailEntities = purchaseDetailService.listByIds(items);

        purchaseDetailEntities.forEach(item -> {
            if (!item.getStatus().equals(WareConstant.PurchaseDetailStatusEnum.CREATED.getCode())
                    && !item.getStatus().equals(WareConstant.PurchaseDetailStatusEnum.ASSIGNED.getCode())) {
                throw new IllegalArgumentException("正在采购，无法进行分配");
            }
        });

        Long finalPurchaseId = purchaseId;
        List<PurchaseDetail> collect = items.stream().map(i -> {
            PurchaseDetail purchaseDetailEntity = new PurchaseDetail();
            purchaseDetailEntity.setId(i);
            purchaseDetailEntity.setPurchaseId(finalPurchaseId);
            purchaseDetailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.ASSIGNED.getCode());
            return purchaseDetailEntity;
        }).collect(Collectors.toList());

        //批量修改
        purchaseDetailService.updateBatchById(collect);

        Purchase purchaseEntity = new Purchase();
        purchaseEntity.setId(purchaseId);
        purchaseEntity.setUpdateTime(new Date());
        this.updateById(purchaseEntity);
    }


    @Override
    public void received(List<Long> ids) {

        //1、确认当前采购单是新建或者是已分配状态
        List<Purchase> collect = null;
        if (!ObjectUtils.isEmpty(ids)) {
            collect = ids.stream().map(this::getById
            ).filter(item ->
                    item.getStatus() == WareConstant.PurchaseStatusEnum.CREATED.getCode() ||
                            item.getStatus() == WareConstant.PurchaseStatusEnum.ASSIGNED.getCode()
            ).peek(item -> {
                //改变完状态的采购单
                item.setStatus(WareConstant.PurchaseStatusEnum.RECEIVE.getCode());
                item.setUpdateTime(new Date());
            }).collect(Collectors.toList());
        }

        //2、改变采购单的状态
        this.updateBatchById(collect);

        //3、改变采购项的状态
        assert collect != null;
        collect.forEach(item -> {
            List<PurchaseDetail> list = purchaseDetailService.listDetailByPurchaseId(item.getId());
            List<PurchaseDetail> detailEntities = list.stream().map(entity -> {

                PurchaseDetail purchaseDetailEntity = new PurchaseDetail();
                purchaseDetailEntity.setId(entity.getId());
                purchaseDetailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.BUYING.getCode());
                return purchaseDetailEntity;
            }).collect(Collectors.toList());
            purchaseDetailService.updateBatchById(detailEntities);

        });

    }

    @Override
    public void done(PurchaseDoneVo doneVo) {

        Long id = doneVo.getId();

        //1、改变采购项的状态
        boolean flag = true;
        List<PurchaseItemDoneVo> items = doneVo.getItems();
        List<PurchaseDetail> updates = new ArrayList<>();

        for (PurchaseItemDoneVo item : items) {
            PurchaseDetail purchaseDetailEntity = new PurchaseDetail();
            if (item.getStatus() == WareConstant.PurchaseDetailStatusEnum.HASERROR.getCode()) {
                flag = false;
                purchaseDetailEntity.setStatus(item.getStatus());
            } else {
                purchaseDetailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.FINISH.getCode());
                //3、将成功采购的进行入库
                //查出当前采购项的详细信息
                PurchaseDetail entity = purchaseDetailService.getById(item.getItemId());
                wareSkuService.addStock(entity.getSkuId(), entity.getWareId(), entity.getSkuNum());

            }
            purchaseDetailEntity.setId(item.getItemId());

            updates.add(purchaseDetailEntity);
        }

        //批量更新
        purchaseDetailService.updateBatchById(updates);

        //2、改变采购单状态
        Purchase purchaseEntity = new Purchase();
        purchaseEntity.setId(id);
        purchaseEntity.setStatus(flag ? WareConstant.PurchaseStatusEnum.FINISH.getCode() : WareConstant.PurchaseStatusEnum.HASERROR.getCode());
        purchaseEntity.setUpdateTime(new Date());
        this.updateById(purchaseEntity);

    }
}




