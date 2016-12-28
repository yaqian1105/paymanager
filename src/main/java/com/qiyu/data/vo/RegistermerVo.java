package com.qiyu.data.vo;


import com.qiyu.common.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by KK on 2016/6/1.
 */
public class RegistermerVo implements Serializable {
    private Long id;
    private String name;//商家名称
    private String agentId;//所属代理商ID
    private String cityId;//市编号
    private String cityName;
    private String areaId;//区编号
    private String areaName;
    private String userName;//用户名
    private String provinceId;//省份
    private String simpleName;//简称
    private String agentSimpleName;
    private int type;//DEFAULT '1' COMMENT '1,个人 2,连锁',
    private String contact;//联系人
    private String phone;//联系方式
    private String  fixedPhone;
    private String detailAddress;//详细地址
    private int status;//申请状态
    private String agentName;//代理商名称
    private String address;//商家地址

    private Date updateAt;//修改时间
    private String updateAtStr;
    private Integer source; //注册来源
    private String aliStoreId;  //支付宝门店号

    public String getAliStoreId() {
        return aliStoreId;
    }

    public void setAliStoreId(String aliStoreId) {
        this.aliStoreId = aliStoreId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private Date createAt;//创建时间
    private String createAtStr;

    public String getCreateAtStr() {
        if(createAt!=null){
           //return DateUtils.formatDate(createAt,"yyyy-MM-dd HH:mm:ss");
            return DateUtil.getTimeStr(createAt);
        }
        return "";
    }

    public void setCreateAtStr(String createAtStr) {
        this.createAtStr = createAtStr;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateAtStr() {
        if(updateAt!=null){
            //return DateUtils.formatDate(updateAt,"yyyy-MM-dd HH:mm:ss");
            return DateUtil.getTimeStr(updateAt);
        }
        return "";
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setUpdateAtStr(String updateAtStr) {
        this.updateAtStr = updateAtStr;
    }

    public String getTypeName(){
        if(type==1){
            return "连锁";
        }else{
            return "个人";
        }
    }
    public String getStatusName(){
        if(status==1){
            return "处理";
        }else if(status==2){
            return "完成";
        }else {
            return "拒绝";
        }
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getAgentSimpleName() {
        if(this.agentSimpleName == null){
            agentSimpleName = "------";
        }
        return agentSimpleName;
    }

    public void setAgentSimpleName(String agentSimpleName) {
        this.agentSimpleName = agentSimpleName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
