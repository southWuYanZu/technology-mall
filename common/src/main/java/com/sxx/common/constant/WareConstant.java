package com.sxx.common.constant;

/**
 * @author shenxianxin
 **/
public class WareConstant {

    public enum PurchaseStatusEnum {
        /**
         * 采购订单枚举
         */
        CREATED(0, "新建"),
        ASSIGNED(1, "已分配"),
        RECEIVE(2, "已领取"),
        FINISH(3, "已完成"),
        HASERROR(4, "有异常"),

        ;

        private final int code;

        private final String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        PurchaseStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }


    public enum PurchaseDetailStatusEnum {
        /**
         * 采购订单详情枚举
         */
        CREATED(0, "新建"),
        ASSIGNED(1, "已分配"),
        BUYING(2, "正在采购"),
        FINISH(3, "已完成"),
        HASERROR(4, "采购失败"),

        ;

        private final int code;

        private final String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        PurchaseDetailStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }


}
