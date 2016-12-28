package com.qiyu.data.vo;

/**
 * Created by liuhui on 2016/7/19.
 */
public class RestaurantPresentLogVo {
    private Long id;
    private Long restaurantId;//门店ID
    private Integer day;    //赠送天数
    private String status;  //状态 0成功 1失败
    private String remark;  //备注
    private String operate; //操作人
    private String createAt;   //赠送天数
    private String updateAt;

    @Override
    public String toString() {
        return "RestaurantPresentLogVo{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", day=" + day +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", operate='" + operate + '\'' +
                ", createAt='" + createAt + '\'' +
                ", updateAt='" + updateAt + '\'' +
                '}';
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

}
