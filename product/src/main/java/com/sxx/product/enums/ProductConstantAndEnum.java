package com.sxx.product.enums;

import com.sxx.common.utils.BaseEnum;

/**
 * 产品枚举常量类
 *
 * @author Mr.shen
 * @since 2022/03/09 下午 8:27
 */
public class ProductConstantAndEnum {

    /**
     * 数据库列名
     */
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ATTR_ID = "attr_id";
    public static final String COLUMN_BRAND_ID = "brand_id";
    public static final String COLUMN_ATTR_NAME = "attr_name";
    public static final String COLUMN_ATTR_TYPE = "attr_type";
    public static final String COLUMN_CATELOG_ID = "catelog_id";
    public static final String COLUMN_FIRST_LETTER = "first_letter";
    public static final String COLUMN_ATTR_GROUP_ID = "attr_group_id";
    public static final String COLUMN_ATTR_GROUP_NAME = "attr_group_name";

    /**
     * 商品属性枚举类
     */
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
        private final int code;

        /**
         * 商品熟悉信息
         */
        private final String value;

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

    }

}
