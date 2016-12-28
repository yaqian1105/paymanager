package com.qiyu.data.vo;

import java.io.Serializable;

public class AgentVo implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 代理商名称
     */
    private String agentName;
    /**
     * 联系名称
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String phone;

    private Integer restaurantCount;
    private Double returnPercentage;    //返佣比例

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRestaurantCount() {
        return restaurantCount;
    }

    public void setRestaurantCount(Integer restaurantCount) {
        this.restaurantCount = restaurantCount;
    }

    public Double getReturnPercentage() {
        return returnPercentage;
    }

    public void setReturnPercentage(Double returnPercentage) {
        this.returnPercentage = returnPercentage;
    }
}
