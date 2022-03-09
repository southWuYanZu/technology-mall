package com.sxx.product.enums;

import com.sxx.common.utils.BaseEnum;

/**
 * @author Mr.shen
 * @since 2022/03/09 下午 8:27
 */
public class ProductEnum {

    public enum AttrEnum implements BaseEnum {
        /**
         * 基本属性
         */
        ATTR_TYPE_BASE(1, "基本属性"),
        /**
         * 销售属性
         */
        ATTR_TYPE_SALE(0, "销售属性");

        /**
         * 商品熟悉编码
         */
        private int code;

        /**
         * 商品熟悉信息
         */
        private String value;

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getValue() {
            return value;
        }

        AttrEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        AttrEnum() {
        }
    }

}
