package com.qiyu.data.vo;

import java.io.Serializable;

/**
 * Created by liuhui on 2016/7/19.
 */
public class PresentVo implements Serializable {
    private Long id;        //门店ID
    private String restaurantName;  //门店名称
    private String merchantName;    //商家名称
    private Integer day;            //剩余天数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "PresentVo{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", MerchantName='" + merchantName + '\'' +
                ", day=" + day +
                '}';
    }
}
