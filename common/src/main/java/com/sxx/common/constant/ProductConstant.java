package com.sxx.common.constant;

/**
 * Description: 商品常量属性
 *
 * @author Mr.shen
 **/
public class ProductConstant {

    public enum AttrEnum {
        /**
         * 销售属性枚举
         */
        ATTR_TYPE_BASE(1, "基本属性"),
        ATTR_TYPE_SALE(0, "销售属性");

        private final int code;

        private final String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        AttrEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

    }


    public enum ProductStatusEnum {
        /**
         * 商品状态枚举
         */
        NEW_SPU(0, "新建"),
        SPU_UP(1, "商品上架"),
        SPU_DOWN(2, "商品下架"),
        ;

        private final int code;

        private final String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        ProductStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

    }

    private ProductConstant() {

    }

}
