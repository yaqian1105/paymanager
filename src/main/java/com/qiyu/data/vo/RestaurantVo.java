package com.qiyu.data.vo;



import com.qiyu.common.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by KK on 2016/6/2.
 */
public class RestaurantVo implements Serializable {
    private String id;
    private String restName;
    private String ali;
    private String aliType;
    private String wx;
    private String wxType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getAli() {
        return ali;
    }

    public void setAli(String ali) {
        this.ali = ali;
    }

    public String getAliType() {
        return aliType;
    }

    public void setAliType(String aliType) {
        this.aliType = aliType;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getWxType() {
        return wxType;
    }

    public void setWxType(String wxType) {
        this.wxType = wxType;
    }
}
