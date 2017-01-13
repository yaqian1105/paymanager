package com.qiyu.data.entity;

import com.qiyu.common.data.IdLongEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 全局常量表
 */
@Entity
@Table(name = "global_constant")
public class GlobalConstant extends IdLongEntity implements Serializable {
    private Long constantNo;//常量编号
    private String constantName;//常量名
    private String constantValue;//常量值
    private String constantRemark;//常量描述

    public Long getConstantNo() {
        return constantNo;
    }

    public void setConstantNo(Long constantNo) {
        this.constantNo = constantNo;
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getConstantRemark() {
        return constantRemark;
    }

    public void setConstantRemark(String constantRemark) {
        this.constantRemark = constantRemark;
    }
}
