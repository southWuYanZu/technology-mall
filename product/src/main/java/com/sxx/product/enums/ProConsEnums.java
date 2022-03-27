package com.sxx.product.enums;

import com.sxx.common.utils.BaseEnum;

/**
 * 产品枚举常量类
 *
 * @author Mr.shen
 * @since 2022/03/09 下午 8:27
 */
public class ProConsEnums {

    /**
     * 数据库列名
     */
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_ATTR_ID = "attr_id";
    public static final String COLUMN_SPU_NAME = "spu_name";
    public static final String COLUMN_BRAND_ID = "brand_id";
    public static final String COLUMN_ATTR_NAME = "attr_name";
    public static final String COLUMN_ATTR_TYPE = "attr_type";
    public static final String COLUMN_CATELOG_ID = "catelog_id";
    public static final String COLUMN_PUBLISH_STATUS = "publish_status";
    public static final String COLUMN_FIRST_LETTER = "first_letter";
    public static final String COLUMN_ATTR_GROUP_ID = "attr_group_id";
    public static final String COLUMN_ATTR_GROUP_NAME = "attr_group_name";

    /**
     * 基本字符数字
     */
    public static final String STR_ZERO = "0";
    public static final String STR_ONE = "1";
    public static final String STR_TWO = "2";
    public static final String STR_THREE = "3";
    public static final String STR_FOUR = "4";
    public static final String STR_FIVE = "5";
    public static final String STR_SIX = "6";
    public static final String STR_SEVEN = "7";
    public static final String STR_EIGHT = "8";
    public static final String STR_NICE = "9";

    /**
     * 基本数字
     */
    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;
    public static final Integer SIX = 6;
    public static final Integer SEVEN = 7;
    public static final Integer EIGHT = 8;
    public static final Integer NICE = 9;

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
