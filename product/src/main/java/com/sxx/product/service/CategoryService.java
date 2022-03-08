package com.sxx.product.service;

import com.sxx.product.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author shenxianxin
 * 针对表【pms_category(商品三级分类)】的数据库操作Service
 * @since 2021-12-02 18:42:19
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询商品品类
     *
     * @return 品类结果集并按三级列表返回
     */
    List<Category> listWithTree();

    /**
     * 根据ids删除菜单
     * @param ids id 集合
     */
    void deleteMenusByIds(Long[] ids);

    /**
     * 根据categoryID查询详细信息进行回写
     *
     * @param categoryId ID
     * @return 回写分组详细信息
     */
    Long[] findCategoryPathById(Long categoryId);
}
