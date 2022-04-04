package com.sxx.elasticsearch.service;


import com.sxx.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author shenxianxin
 * @since 2022/4/3 21:43:06
 */
public interface ProductSaveService {

    /**
     * 查询产品上传状态
     *
     * @param skuEsModels skuEsModels
     * @return 产品上传状
     * @throws IOException IOException
     */
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
