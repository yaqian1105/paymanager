package com.qiyu.data.vo;

import com.qiyu.common.utils.DateUtil;
import java.io.Serializable;
import java.util.Date;

/**
 * 结果记录表
 */
public class ResultRecordSheetVo  implements Serializable {
    private String id;
    private String restaurantName;//店铺名称
    private Long restaurantId;//店铺ID
    private String materialCategory;//资料类目
    private String materialType;//资料类型
    private String resultStatus;//结果状态(0：申请中   1：成功   -1: 失败）
    private String resultRemark;//结果说明（成功及保存商户号及密钥）
    private Date createAt;//申请时间
    private String creatAtStr;//申请时间显示
    private Date updateAt;//申请时间
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public java.util.Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(java.util.Date createAt) {
        this.createAt = createAt;
    }

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

    public String getCreatAtStr() {
        if(createAt!=null){
            creatAtStr = DateUtil.getTimeStr(createAt);
        }
        return creatAtStr;
    }

    public void setCreatAtStr(String creatAtStr) {
        this.creatAtStr = creatAtStr;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
