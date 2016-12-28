package com.qiyu.data.enums;


import com.qiyu.common.enums.BaseEnum;

public enum ProtocolDepositLogStatus implements BaseEnum {


    CREATE(1, "创建"),
    PAYED(2, "已支付"),
    APPLY_REFUND(3, "申请退款"),
    REFUNDED(4, "已退款"),
    REFUND_SUCCESS(5, "退款成功"),
    REFUND_FAILURE(6, "退款失败");

    private int index;
    private String description;

    ProtocolDepositLogStatus(int index, String description) {
        this.index = index;
        this.description = description;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
