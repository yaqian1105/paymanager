package com.qiyu.paymanager.constant;

/**
 * Created by ZYQ on 2017/1/6.
 */
public class Constants {
    /**
     * 支付通道常量
     */
    //支付宝通道
    public static final long ALI_CMBC =  101;//民生银行
    public static final long ALI_CNCB =  102;//中信银行
    public static final long ALI_CIB =  103;//兴业银行
    public static final long ALI_KFT =  104;//快付通银行
    public static final long ALI_ISV =  11;//支付宝ISV
    public static final long ALI_PAY_2 =  12;//支付宝2.0
    //微信通道
    public static final long WECHAT_CMBC = 201;//民生银行
    public static final long WECHAT_CNCB = 202;//中信银行微信
    public static final long WECHAT_CIB =  203;//兴业银行微信
    public static final long WECHAT_KFT =  204;//快付通银行
    public static final long WECHAT_FREE = 21;//微信自有商户
    public static final long WECHAT_OTHER_SUB = 22;//微信其他子商户
    public static final long WECHAT_QY_SUB = 23;//旗鱼子商户

    /**
     * 商户入驻类型
     */
    public static final int SIGN_TYPE_0 = 0;//个体工商户;
    public static final int SIGN_TYPE_1 = 1;//企业;
    public static final int SIGN_TYPE_2 = 2;//个人;


    public static final String SIGN_TYPE_0_STR = "个体工商户";
    public static final String SIGN_TYPE_1_STR = "企业";
    public static final String SIGN_TYPE_2_STR = "个人";

    //资料类型
    public static final String MATERIAL_TYPE = "进件";


    /****全局常量   GLOBAL_ ****/

    public static final String GLOBAL_ACCOUNT_DAY = "account_day";//代理商佣金结算日

}
