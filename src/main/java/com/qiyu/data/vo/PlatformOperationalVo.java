package com.qiyu.data.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/15.
 */
public class PlatformOperationalVo   implements Serializable {

    private String agentName;   //代理商名称
    private double money;       //流水金额
    private String merchantName;     //商户名称
    private Long orderCount;    //订单数量
    private double sumMoney;    //金额汇总
    private Long restaurantCount;    //商户汇总
    private String dayStr;      //时间轴
    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Long getRestaurantCount() {
        return restaurantCount;
    }

    public void setRestaurantCount(Long restaurantCount) {
        this.restaurantCount = restaurantCount;
    }

    public String getDayStr() {
        return dayStr;
    }

    public void setDayStr(String dayStr) {
        this.dayStr = dayStr;
    }
}
