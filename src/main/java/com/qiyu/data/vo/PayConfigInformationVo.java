package com.qiyu.data.vo;

import java.util.Date;


/**
 * 支付申请信息
 */
public class PayConfigInformationVo {
    private Long id;
    /**
     * 支付通道（ali  weixin）
     */
    private String platform;
    private String configNo;    //用于支付配置的支付通道存取
    private String channelName; //渠道名称
    private Date createAt; //创建时间
    private Date updateAt; //修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getConfigNo() {
        return configNo;
    }

    public void setConfigNo(String configNo) {
        this.configNo = configNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}