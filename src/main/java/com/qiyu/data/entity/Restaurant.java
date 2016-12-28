package com.qiyu.data.entity;

import com.qiyu.common.data.IdLongEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by KK on 2016/6/1.
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '餐馆门店名称',
 `agent_id` int(20) DEFAULT NULL COMMENT '代理商id',
 `merchant_id` int(20) DEFAULT NULL COMMENT '商家id',
 `expried_date` date DEFAULT NULL COMMENT '软件使用到期时间',
 `food_version` int(11) NOT NULL COMMENT '菜品版本号， 当后台菜品或做法更新时，版本号+1',
 `money` double DEFAULT NULL COMMENT '余额',
 `pinyin` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '拼音',
 `detail_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
 `header_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
 `qrcode_pic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
 `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
 `fixed_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '固定电话',
 `last_pay_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后充值时间',
 `create_at` datetime DEFAULT NULL COMMENT '创建时间',
 `update_at` datetime DEFAULT NULL COMMENT '修改时间',
 */
@Entity
@Table(name = "restaurant")
public class Restaurant extends IdLongEntity implements Serializable {

    /**
     * 餐馆门店名称
     */
    private String name;
    /**
     * 软件使用到期时间
     */
    private Date expriedDate;
    /**
     * 余额
     */
    private Double money;
    /**
     * 菜品版本号， 当后台菜品或做法更新时，版本号+1
     */
    private long foodVersion;
    /**
     * 餐馆id
     */
    private long merchantId;
    /**
     * 代理商id
     */
    private long agentId;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * 详细地址
     */
    private String detailAddress;
    /**
     * 头像
     */
    private String headerPic;
    /**
     * 二维码图片
     */
    private String qrcodePic;
    /**
     * 餐馆描述
     */
    private String content;
    /**
     * 固定电话
     */
    private String fixedPhone;
    /**
     * 最后一次充值时间
     */
    private Date lastPayTime;
    /**
     * 起送费
     */
    private double startMoney;
    /**
     * 运费
     */
    private double freight;
    /**
     * 送达时间
     */
    private int sendTime;
    /**
     * 开始营业时间
     */
    private Time openTime;
    /**
     * 结束营业时间
     */
    private Time closeTime;

    /**
     * 是否支持餐后支付(0=否 1=是
     * @return
     */
    private int isAfterMeal;

    /**
     * 打印类型(1=按菜品打印|2=按分类打印)',
     */
    private int printType;
    public Date getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(Date lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpriedDate() {
        return expriedDate;
    }

    public void setExpriedDate(Date expriedDate) {
        this.expriedDate = expriedDate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public long getFoodVersion() {
        return foodVersion;
    }

    public void setFoodVersion(long foodVersion) {
        this.foodVersion = foodVersion;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }

    public String getQrcodePic() {
        return qrcodePic;
    }

    public void setQrcodePic(String qrcodePic) {
        this.qrcodePic = qrcodePic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(double startMoney) {
        this.startMoney = startMoney;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public int getSendTime() {
        return sendTime;
    }

    public void setSendTime(int sendTime) {
        this.sendTime = sendTime;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public int getIsAfterMeal() {
        return isAfterMeal;
    }

    public void setIsAfterMeal(int isAfterMeal) {
        this.isAfterMeal = isAfterMeal;
    }

    public int getPrintType() {
        return printType;
    }

    public void setPrintType(int printType) {
        this.printType = printType;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }



}
