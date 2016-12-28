package com.qiyu.data.entity;

import com.qiyu.common.data.IdLongEntity;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by KK on 2016/6/2.
 */
@Entity
@Table(name = "restaurant_staff")
public class RestaurantStaff  extends IdLongEntity implements Serializable {

    public static final int HASH_INTERATIONS=1024;

    public static final String ROLE_ADMIN="admin";
    //餐馆经理
    public static final String ROLE_MANAGER="manager";
    //餐馆财务
    public static final String ROLE_ACCOUNTANT="accountant";
    //门店店长
    public static final String ROLE_SHOPKEEPER="shopkeeper";
    //普通员工
    public static final String ROLE_USER="user";

    private String name;
    private String restaurantId;
    private String userName;
    /**
     * 密码
     */
    private transient String password;
    /**
     * 密码加密盐
     */
    private transient String salt;
    private String role;//?
    /**
     * 是否失效
     */
    private boolean isExpired;
    /**
     * 失效日期
     */
    private Date expiredDate;
    private String staffNo;
    private String merchantId;
    private String phone;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean expired) {
        isExpired = expired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public List<String> getRoleList(){
        List<String> list=new ArrayList<String>();
        if(StringUtils.isNotEmpty(role)) {
            role = role.replace("，", ",");
            if (role.contains(",")) {
                String[] str = role.split(",");
                return Arrays.asList(str);
            } else {
                list.add(role);
            }
        }
        return list;
    }
}
