package com.qiyu.data.entity;



import com.qiyu.common.data.IdLongEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 结果记录表
 */
@Entity
@Table(name = "result_record_sheet")
public class ResultRecordSheet extends IdLongEntity implements Serializable {
    private Long restaurantId;//店铺ID
   // private String restaurantName;//店铺名称
    private String materialCategory;//资料类目
    private String materialType;//资料类型
    private String resultStatus;//结果状态(0：申请中   1：成功   -1: 失败）
    private String resultRemark;//结果说明（成功及保存商户号及密钥）

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultRemark() {
        return resultRemark;
    }

    public void setResultRemark(String resultRemark) {
        this.resultRemark = resultRemark;
    }
}
