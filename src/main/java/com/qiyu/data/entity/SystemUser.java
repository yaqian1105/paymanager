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
 * Created by 产品 on 2016/6/26.
 */

@Entity
@Table(name = "system_user")
public class SystemUser extends IdLongEntity implements Serializable {

    public static final int HASH_INTERATIONS=1024;
    //代理商管理员
    public static final String ROLE_ADMIN="admin";
    //餐馆经理
    public static final String ROLE_MANAGER="manager";
    //餐馆财务
    public static final String ROLE_ACCOUNTANT="accountant";
    //门店店长
    public static final String ROLE_SHOPKEEPER="shopkeeper";
    //普通员工
    public static final String ROLE_USER="user";

    private String userName;
    /**
     * 密码
     */
    private transient String password;
    /**
     * 密码加密盐
     */
    private transient String salt;
    /**
     * 是否失效
     */
    private boolean isExpired;
    /**
     * 失效日期
     */
    private Date expiredDate;
    /**
     * 角色
     */
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
