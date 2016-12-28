package com.qiyu.data.vo;

import java.util.Date;

/**
 * 支付配置信息
 */
public class SetConfigVo {
    private Long id;
    private Long restaurantId;   //商户ID
    private String platform;   //支付方式
    /*
     *  支付通道
     *  支付宝：101民生银行，102中信银行，103兴业银行，11 支付宝ISV，12支付宝2.0 \r\n
     *  微信：201民生银行，202中信银行微信，203兴业银行微信，21微信自有商户，22微信其他子商户，23旗鱼子商户）
     */
    private String paymentChannel;
    private Double rate;   //费率
    private Integer settlementType;    //支付方式（0：T+0  1：T+1）

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }
}
