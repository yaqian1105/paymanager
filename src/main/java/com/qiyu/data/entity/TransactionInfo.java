package com.qiyu.data.entity;


import com.qiyu.common.data.IdLongEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "transaction_info")
public class TransactionInfo extends IdLongEntity implements Serializable {

     private String reqMsgId;    //订单流水号
     private String smzfMsgId;   //平台流水号
     private String transactionNumber;   //交易号
     private Long restaurantId;   //门店ID
     private String restaurantName;//门店名称
     private String merchantName;//商家名称
     private Long merchantId; //下游商家
     private Long agentId;  //代理商Id
     private String channelNo;   //支付渠道（ali  weixin）
     private String channelType;  //支付通道（支付宝：101民生银行，102中信银行，103兴业银行，11 支付宝ISV，12支付宝2.0 \r\n  微信：201民生银行，202中信银行微信，203兴业银行微信，21微信自有商户，22微信其他子商户，23旗鱼子商户）根据渠道信息表channel_no
     private Double totalAmount; //支付金额
     private Double commission; //参与返佣金额（在走银行通道下和支付金额相同）
     private Double serviceCharge;   //服务费（参与返佣金额*代理商分润比例）
     private String buyerId;    //买家编号
     private String merchantCode;   //银行商户编码
     private String status;//交易状态
     private Double orderAmount;//原价

    public String getReqMsgId() {
        return reqMsgId;
    }

    public void setReqMsgId(String reqMsgId) {
        this.reqMsgId = reqMsgId;
    }

    public String getSmzfMsgId() {
        return smzfMsgId;
    }

    public void setSmzfMsgId(String smzfMsgId) {
        this.smzfMsgId = smzfMsgId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
