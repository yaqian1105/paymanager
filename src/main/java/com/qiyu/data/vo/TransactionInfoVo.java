package com.qiyu.data.vo;


import java.io.Serializable;

public class TransactionInfoVo implements Serializable {

    private Long id;
    private Long agentId;   //代理商ID
    private String restaurantName; //门店名
    private String merchantName; //商家名
    private String reqMsgId;    //订单流水号
    private String smzfMsgId;   //平台流水号
    private String channelNum;   //交易号
    private Double totalAmount; //支付金额
    private Double orderAmount; //订单金额
    private String platform;   //来源
    private String channelName;  //通道
    private Double commission; //参与返佣金额（在走银行通道下和支付金额相同）
    private Double serviceCharge;   //服务费（参与返佣金额*代理商分润比例）
    private String operator;    // 操作人
    private Integer status;     //状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getOperator() {
        if(operator==null||operator.equals("")){
            return "--";
        }
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
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
}
