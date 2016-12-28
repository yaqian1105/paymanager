package com.qiyu.data.vo;

import java.util.Date;

/**
 * 支付配置信息
 */
public class PayConfigVo {
    private Long id;
    private Long restaurantId;   //商户ID
    private String restaurantName;   //商户名称
    private String platform;   //支付方式
    /*
     *  支付通道
     *  支付宝：101民生银行，102中信银行，103兴业银行，11 支付宝ISV，12支付宝2.0 \r\n
     *  微信：201民生银行，202中信银行微信，203兴业银行微信，21微信自有商户，22微信其他子商户，23旗鱼子商户）
     */
    private String paymentChannel;
    private Double rate;   //费率
    private Integer settlementType;    //支付方式（0：T+0  1：T+1）
    private Integer usedType;   //使用状态
    private String channelMerchantId; //渠道商户号
    private String channelMerchantKey;   //渠道商户密钥
    private String email; //邮箱
    private String aliStoreId;   //支付宝口碑店铺ID
    private String aliPid;   //合作服务商ID(PID)(用于阿里）
    private String saftKey;   //安全校验码
    private String appid;   //appId
    private String privateKey;   //私有密钥
    private String publicKey;   //公有私钥
    private Integer isSubMerchant;    //是否子商户
    private String subMerchantId;   //子商户号
    private String payMerchantId;   //第三方支付商户号
    private String pid;   //合作者身份
    private String appSecret;   //应用密钥
    private String apiSecret;   //API密钥
    private String apiclientCert;   //pem格式，用于退款及退款查询
    private String apiclientKey;   //pem格式，用于退款及退款查询
    private String payAccount;   //支付账号
    private String payKey;   //支付密钥
    private String accessToken;   //访问令牌
    private String appAuthToken;  //授权码
    private Date createAt; //创建时间
    private Date updateAt; //修改时间

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }

    public Integer getUsedType() {
        return usedType;
    }

    public void setUsedType(Integer usedType) {
        this.usedType = usedType;
    }

    public Integer getIsSubMerchant() {
        return isSubMerchant;
    }

    public void setIsSubMerchant(Integer isSubMerchant) {
        this.isSubMerchant = isSubMerchant;
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

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getChannelMerchantKey() {
        return channelMerchantKey;
    }

    public void setChannelMerchantKey(String channelMerchantKey) {
        this.channelMerchantKey = channelMerchantKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAliStoreId() {
        return aliStoreId;
    }

    public void setAliStoreId(String aliStoreId) {
        this.aliStoreId = aliStoreId;
    }

    public String getAliPid() {
        return aliPid;
    }

    public void setAliPid(String aliPid) {
        this.aliPid = aliPid;
    }

    public String getSaftKey() {
        return saftKey;
    }

    public void setSaftKey(String saftKey) {
        this.saftKey = saftKey;
    }

    public String getChannelMerchantId() {
        return channelMerchantId;
    }

    public void setChannelMerchantId(String channelMerchantId) {
        this.channelMerchantId = channelMerchantId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getPayMerchantId() {
        return payMerchantId;
    }

    public void setPayMerchantId(String payMerchantId) {
        this.payMerchantId = payMerchantId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getApiclientCert() {
        return apiclientCert;
    }

    public void setApiclientCert(String apiclientCert) {
        this.apiclientCert = apiclientCert;
    }

    public String getApiclientKey() {
        return apiclientKey;
    }

    public void setApiclientKey(String apiclientKey) {
        this.apiclientKey = apiclientKey;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAppAuthToken() {
        return appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        this.appAuthToken = appAuthToken;
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
