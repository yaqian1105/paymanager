package com.qiyu.data.entity;

import com.yunjiangzhe.tools.data.IdLongEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 支付申请信息
 */
@Entity
@Table(name = "pay_information")
public class PayInformation extends IdLongEntity {
    /**
     * 门店ID
     */
    private Long restaurantId;
    /**
     * 商户入驻类型0企业1个人
     */
    private int restaurantSignType;
    /**
     * 支付通道（ali  weixin）
     */
    private String platform;
    /**
     * 支付方式（0：支付宝ISV）
     */
    private String paymentChannel;

    /**
     * 经营者身份证正面照
     */
    private String operateIdcardPositive;
    /**
     * 经营者身份证反面照
     */
    private String operateIdcardReverse;
    /**
     * 企业logo
     */
    private String enterpriseLogo;
    private String accountName;   //账户名

    /**
     * 营业执照名称
     */
    private String businessLicenseName;
    /**
     * 营业执照注册号
     */
    private String registerNo;
    /**
     * 营业执照单位住所
     */
    private String address;
    /**
     * 经营范围
     */
    private String scope;
    /**
     * 经营期限
     */
    private String timeLimit;
    /**
     * 营业执照
     */
    private String businessLicense;
    /**
     * 授权函
     */
    private String authLetter;
    /**
     * 经营类目
     */
    private String operateType;
    /**
     * 经营资质
     */
    private String operateConditions;
    /**
     * 接入网址
     */
    private String webSite;
    /**
     * APP名称
     */
    private String appName;
    private String documentSubject;   //证件主体
    private String rangeOfExperience;   //经验范围
    private String storeName;   //门店名称
    private String storeAddress;   //门店地址
    private String wordMouthCategory;   //口碑类目
    /**
     * 店铺店招照片
     */
    private String storeImage;
    /**
     * 店铺内景照片
     */
    private String storeImageInner;
    /**
     *联系人姓名
     */
    private String contactName;
    /**
     * 联系人电子邮箱
     */
    private String email;
    /**
     * 联系人手机号
     */
    private String phone;

    /**
     * 法人姓名
     */
    private String legalRepresentativeName;
    /**
     * 法人证件号码
     */
    private String legalRepresentativeCertNo;
    /**
     * 证件有效期
     */
    private String legalRepresentativeCertIndate;
    /**
     * 企业对公银行账户号
     */
    private String bankCardNo;

    private String bankDeposit;   //开户银行
    private String bankDepositAddress;   //开户银行所在地
    /**
     * 法人证件类型
     */
    private String legalRepresentativeCertType;
    /**
     * 企业对公账户名称
     */
    private String bankAccountName;
    /**
     * 企业对公账户开户行支行全称
     */
    private String businessBankSub;
    /**
     * 组织机构代码证号码
     */
    private String orgCodeCertificateNo;
    /**
     * 组织机构代码证图片
     */
    private String orgCodeCertificatePic;
    /**
     * 银行预留手机号
     */
    private String bankAccountMobile;

    /**
     * 是否三证合一
     * 1是,0不是
     */
    private int threeInOne;
    /**
     * 经营者身份证正面照id
     */
    private String operateIdcardPositiveId;
    /**
     * 经营者身份证反面照id
     */
    private String operateIdcardReverseId;

    /**
     * 企业logo id
     */
    private String enterpriseLogoId;
    /**
     * 营业执照ID
     */
    private String businessLicenseId;
    /**
     * 授权函Id
     */
    private String authLetterId;
    /**
     * 经营资质id
     */
    private String operateConditionsId;
    /**
     * 店铺店招照片id
     */
    private String storeImageId;
    /**
     * 店铺内景照片id
     */
    private String storeImageInnerId;
    /**
     * 是否为长期  1 是 0 不是
     */
    private int longDate;
    /**
     * 店铺内景照片第二张
     */
    private String storeImageSecInner;
    /**
     * 店铺内景照片第三张
     */
    private String storeImageThreeInner;
    /**
     * 店铺内景照片第二张id
     */
    private String storeImageSecInnerId;
    /**
     * 店铺内景照片第三张id
     */
    private String storeImageThreeInnerId;
    /**
     * 组织机构代码证Id
     */
    private String orgCodeCertificatePicId;

    private String wechatCategory;  //微信类目
    private String aliCategory;     //阿里列名
    private Double tzHandlingFee;   //tz单笔提现手续费(元/笔)
    private Double tzFeeRate;  //tz交易手续费扣率(‰)
    private Double toFeeRate; //to交易手续费扣率(‰)
    private Double toHandlingFee;   //to单笔提现手续费(元/笔)
    private String merchantName;  //商户名称
    private String merchantSimpleName;     //商户简称
    private String merchantAddress;  //商户地址
    private String merchantPhone;  //商户联系电话
    private String bankCardNumbe;     //银行卡账户联名号

    private String taxRegistration;  //税务登记URL
    private String legalPersonSettlementCard;     //法人结算卡正面/银行卡正面
    private String legalSettlementCard;  //法人结算卡反面/银行卡反面
    private String accountOpeningLicense;  //开户许可证/手持身份证正面照

    private Double rate;    //费率
    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantSignType() {
        return restaurantSignType;
    }

    public void setRestaurantSignType(int restaurantSignType) {
        this.restaurantSignType = restaurantSignType;
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

    public String getOperateIdcardPositive() {
        return operateIdcardPositive;
    }

    public void setOperateIdcardPositive(String operateIdcardPositive) {
        this.operateIdcardPositive = operateIdcardPositive;
    }

    public String getOperateIdcardReverse() {
        return operateIdcardReverse;
    }

    public void setOperateIdcardReverse(String operateIdcardReverse) {
        this.operateIdcardReverse = operateIdcardReverse;
    }

    public String getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(String enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBusinessLicenseName() {
        return businessLicenseName;
    }

    public void setBusinessLicenseName(String businessLicenseName) {
        this.businessLicenseName = businessLicenseName;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getAuthLetter() {
        return authLetter;
    }

    public void setAuthLetter(String authLetter) {
        this.authLetter = authLetter;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateConditions() {
        return operateConditions;
    }

    public void setOperateConditions(String operateConditions) {
        this.operateConditions = operateConditions;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDocumentSubject() {
        return documentSubject;
    }

    public void setDocumentSubject(String documentSubject) {
        this.documentSubject = documentSubject;
    }

    public String getRangeOfExperience() {
        return rangeOfExperience;
    }

    public void setRangeOfExperience(String rangeOfExperience) {
        this.rangeOfExperience = rangeOfExperience;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getWordMouthCategory() {
        return wordMouthCategory;
    }

    public void setWordMouthCategory(String wordMouthCategory) {
        this.wordMouthCategory = wordMouthCategory;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }

    public String getStoreImageInner() {
        return storeImageInner;
    }

    public void setStoreImageInner(String storeImageInner) {
        this.storeImageInner = storeImageInner;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLegalRepresentativeName() {
        return legalRepresentativeName;
    }

    public void setLegalRepresentativeName(String legalRepresentativeName) {
        this.legalRepresentativeName = legalRepresentativeName;
    }

    public String getLegalRepresentativeCertNo() {
        return legalRepresentativeCertNo;
    }

    public void setLegalRepresentativeCertNo(String legalRepresentativeCertNo) {
        this.legalRepresentativeCertNo = legalRepresentativeCertNo;
    }

    public String getLegalRepresentativeCertIndate() {
        return legalRepresentativeCertIndate;
    }

    public void setLegalRepresentativeCertIndate(String legalRepresentativeCertIndate) {
        this.legalRepresentativeCertIndate = legalRepresentativeCertIndate;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankDeposit() {
        return bankDeposit;
    }

    public void setBankDeposit(String bankDeposit) {
        this.bankDeposit = bankDeposit;
    }

    public String getBankDepositAddress() {
        return bankDepositAddress;
    }

    public void setBankDepositAddress(String bankDepositAddress) {
        this.bankDepositAddress = bankDepositAddress;
    }

    public String getLegalRepresentativeCertType() {
        return legalRepresentativeCertType;
    }

    public void setLegalRepresentativeCertType(String legalRepresentativeCertType) {
        this.legalRepresentativeCertType = legalRepresentativeCertType;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBusinessBankSub() {
        return businessBankSub;
    }

    public void setBusinessBankSub(String businessBankSub) {
        this.businessBankSub = businessBankSub;
    }

    public String getOrgCodeCertificateNo() {
        return orgCodeCertificateNo;
    }

    public void setOrgCodeCertificateNo(String orgCodeCertificateNo) {
        this.orgCodeCertificateNo = orgCodeCertificateNo;
    }

    public String getOrgCodeCertificatePic() {
        return orgCodeCertificatePic;
    }

    public void setOrgCodeCertificatePic(String orgCodeCertificatePic) {
        this.orgCodeCertificatePic = orgCodeCertificatePic;
    }

    public String getBankAccountMobile() {
        return bankAccountMobile;
    }

    public void setBankAccountMobile(String bankAccountMobile) {
        this.bankAccountMobile = bankAccountMobile;
    }

    public int getThreeInOne() {
        return threeInOne;
    }

    public void setThreeInOne(int threeInOne) {
        this.threeInOne = threeInOne;
    }

    public String getOperateIdcardPositiveId() {
        return operateIdcardPositiveId;
    }

    public void setOperateIdcardPositiveId(String operateIdcardPositiveId) {
        this.operateIdcardPositiveId = operateIdcardPositiveId;
    }

    public String getOperateIdcardReverseId() {
        return operateIdcardReverseId;
    }

    public void setOperateIdcardReverseId(String operateIdcardReverseId) {
        this.operateIdcardReverseId = operateIdcardReverseId;
    }

    public String getEnterpriseLogoId() {
        return enterpriseLogoId;
    }

    public void setEnterpriseLogoId(String enterpriseLogoId) {
        this.enterpriseLogoId = enterpriseLogoId;
    }

    public String getBusinessLicenseId() {
        return businessLicenseId;
    }

    public void setBusinessLicenseId(String businessLicenseId) {
        this.businessLicenseId = businessLicenseId;
    }

    public String getAuthLetterId() {
        return authLetterId;
    }

    public void setAuthLetterId(String authLetterId) {
        this.authLetterId = authLetterId;
    }

    public String getOperateConditionsId() {
        return operateConditionsId;
    }

    public void setOperateConditionsId(String operateConditionsId) {
        this.operateConditionsId = operateConditionsId;
    }

    public String getStoreImageId() {
        return storeImageId;
    }

    public void setStoreImageId(String storeImageId) {
        this.storeImageId = storeImageId;
    }

    public String getStoreImageInnerId() {
        return storeImageInnerId;
    }

    public void setStoreImageInnerId(String storeImageInnerId) {
        this.storeImageInnerId = storeImageInnerId;
    }

    public int getLongDate() {
        return longDate;
    }

    public void setLongDate(int longDate) {
        this.longDate = longDate;
    }

    public String getStoreImageSecInner() {
        return storeImageSecInner;
    }

    public void setStoreImageSecInner(String storeImageSecInner) {
        this.storeImageSecInner = storeImageSecInner;
    }

    public String getStoreImageThreeInner() {
        return storeImageThreeInner;
    }

    public void setStoreImageThreeInner(String storeImageThreeInner) {
        this.storeImageThreeInner = storeImageThreeInner;
    }

    public String getStoreImageSecInnerId() {
        return storeImageSecInnerId;
    }

    public void setStoreImageSecInnerId(String storeImageSecInnerId) {
        this.storeImageSecInnerId = storeImageSecInnerId;
    }

    public String getStoreImageThreeInnerId() {
        return storeImageThreeInnerId;
    }

    public void setStoreImageThreeInnerId(String storeImageThreeInnerId) {
        this.storeImageThreeInnerId = storeImageThreeInnerId;
    }

    public String getOrgCodeCertificatePicId() {
        return orgCodeCertificatePicId;
    }

    public void setOrgCodeCertificatePicId(String orgCodeCertificatePicId) {
        this.orgCodeCertificatePicId = orgCodeCertificatePicId;
    }

    public String getWechatCategory() {
        return wechatCategory;
    }

    public void setWechatCategory(String wechatCategory) {
        this.wechatCategory = wechatCategory;
    }

    public String getAliCategory() {
        return aliCategory;
    }

    public void setAliCategory(String aliCategory) {
        this.aliCategory = aliCategory;
    }

    public Double getTzHandlingFee() {
        return tzHandlingFee;
    }

    public void setTzHandlingFee(Double tzHandlingFee) {
        this.tzHandlingFee = tzHandlingFee;
    }

    public Double getTzFeeRate() {
        return tzFeeRate;
    }

    public void setTzFeeRate(Double tzFeeRate) {
        this.tzFeeRate = tzFeeRate;
    }

    public Double getToFeeRate() {
        return toFeeRate;
    }

    public void setToFeeRate(Double toFeeRate) {
        this.toFeeRate = toFeeRate;
    }

    public Double getToHandlingFee() {
        return toHandlingFee;
    }

    public void setToHandlingFee(Double toHandlingFee) {
        this.toHandlingFee = toHandlingFee;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantSimpleName() {
        return merchantSimpleName;
    }

    public void setMerchantSimpleName(String merchantSimpleName) {
        this.merchantSimpleName = merchantSimpleName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public String getBankCardNumbe() {
        return bankCardNumbe;
    }

    public void setBankCardNumbe(String bankCardNumbe) {
        this.bankCardNumbe = bankCardNumbe;
    }

    public String getTaxRegistration() {
        return taxRegistration;
    }

    public void setTaxRegistration(String taxRegistration) {
        this.taxRegistration = taxRegistration;
    }

    public String getLegalPersonSettlementCard() {
        return legalPersonSettlementCard;
    }

    public void setLegalPersonSettlementCard(String legalPersonSettlementCard) {
        this.legalPersonSettlementCard = legalPersonSettlementCard;
    }

    public String getLegalSettlementCard() {
        return legalSettlementCard;
    }

    public void setLegalSettlementCard(String legalSettlementCard) {
        this.legalSettlementCard = legalSettlementCard;
    }

    public String getAccountOpeningLicense() {
        return accountOpeningLicense;
    }

    public void setAccountOpeningLicense(String accountOpeningLicense) {
        this.accountOpeningLicense = accountOpeningLicense;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}