package com.qiyu.data.vo;


import com.qiyu.common.utils.DateUtil;
import org.apache.http.client.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by KK on 2016/6/1.
 */
public class MerchantVo implements Serializable {
    private Long id;
    private String agentId;//所属代理商
    private String agentName;   //代理商名称
    private String merchantName;    //商家名称
    private String simpleName;  //简称
    private String contact; //联系人
    private String phone;
    private String userName;
    private String fixedPhone;
    private int restaurantCount; //店铺数
    private int transactionCount; //交易笔数
    private double transactionFlow; //交易流水
    private double returnWater; //返佣流水
    private double commission; //佣金

    public int getRestaurantCount() {
        return restaurantCount;
    }

    public void setRestaurantCount(int restaurantCount) {
        this.restaurantCount = restaurantCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTransactionFlow() {
        return transactionFlow;
    }

    public void setTransactionFlow(double transactionFlow) {
        this.transactionFlow = transactionFlow;
    }

    public double getReturnWater() {
        return returnWater;
    }

    public void setReturnWater(double returnWater) {
        this.returnWater = returnWater;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }
}