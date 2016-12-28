package com.qiyu.data;


import com.qiyu.common.exception.BaseRetCode;

/**
 * Created by Dean on 2016/3/11.
 */
public class RetCode extends BaseRetCode {



    //基础
    public static  final int LOGIN_USER_NAME_NOT_EXISTS_ERROR=10002;
    public static  final int USER_NAME_HAS_EXIST=10003;
    public static  final int USER_HAS_NO_EXIST=10004;
    public static  final int USER_HAS_NOT_LOGIN=10005;
    public static  final int DEVICE_NOT_FOUND=10006;
    public static  final int FOOD_HAS_EXPIRED=10007;
    public static  final int RESAURANT_HAS_EXPIRED=10008;
    public static  final int RESAURANT_VERSION_ERROR=10009;
    public static  final int USER_LOGIN_FAIL=10010;
    public static  final int FOOD_NOT_CORRECT=10011;
    public static  final int DEVICE_NOT_SUIT_RESAURANT=10012;
    public static  final int DEVICEID_IS_NULL=10013;
    public static  final int DEVICENAME_IS_NULL=10014;
    public static  final int DEVICEID_IS_EXISTS=10015;
    public static  final int DEVICEID_IS_NOT_SUIT=10016;
    public static  final int ORIGINALPRICE_NOT_CORRECT=10017;
    public static  final int PRESENTPRICE_NOT_CORRECT=10018;
    public static  final int DISCOUNT_NOT_CORRECT=10019;
    public static  final int FOODNAME_IS_EMPTY=10020;
    public static  final int PACKAGE_IS_NOT_EXISTS=10021;
    public static  final int NAME_IS_NULL=10022;
    public static  final int PHONE_HAS_EXISTS=10023;
    public static  final int STAFF_HAS_EXISTS=10024;
    public static  final int NO_DATA_FOUND=10025;
    public static  final int DISCOUNT_NO_EXISTS=10026;
    public static  final int FOOD_TYPE_NOT_EXISTS=10027;
    public static  final int FOOD_TYPE_EXISTS_FOOD=10028;
    public static  final int NO_ACCESS=10029;
    public static  final int PRINTEREN_IS_NULL=10030;
    public static  final int PRINTERKEY_IS_NULL=10031;
    public static  final int PRINTER_IS_EXISTS=10032;
    public static  final int PRINTER_TYPE_IS_NULL=10033;
    public static  final int SHOPKEEPER_IS_EXISTS=10034;

    //套餐
    public static final int PACKAGE_NAME_IS_EMPTY = 11001;

    //订单
    public static  final int ORERDER_NOT_EXISTS_ERROR=20001;
    public static  final int RESAURANT_NOT_EXISTS_ERROR=20002;
    public static  final int DESK_NOT_EXISTS_ERROR=20003;
    public static  final int ORDER_FOOD_DETAILS_ERROR=20004;
    public static  final int ORDER_FOOD_DISCOUNT_ERROR=20005;
    public static  final int ORDER_FOOD_UNIT_PRICE_ERROR=20006;
    public static  final int ORDER_FOOD_PRICE_ERROR=20007;
    public static  final int ORDER_PRICE_ERROR=20008;
    public static  final int ORDER_GIFT_ERROR=20009;
    public static  final int ORDER_HAS_PAYED_ERROR=20010;
    public static  final int ORDER_HAS_PRINTED_ERROR=20011;
    public static  final int ORDER_HAS_INVOICESED_ERROR=20012;

    //排队
    public static  final int LINE_NUM_NOT_SUITABLE=30001;
    public static  final int DESKTYPE_NO_EXIST=30002;


    //代理商
    public static  final int AGENT_USER_ACCOUNTPATTER_ERROR =40001;
    public static  final int AGENT_USER_NOT_EXIST =40002;
    public static  final int AGENT_USER_PASSWORD_ERROR =40003;
    public static  final int AGENT_USER_PASSWORD_RESET_ERROR =40004;
    public static  final int AGENT_USER_PASSWORD_RESET_NORECORD =40005;
    public static  final int AGENT_USER_PASSWORD_RESET_NOTVALID =40006;
    public static  final int AGENT_USER_PASSWORD_RESET_EXPIRED =40007;
    public static  final int AGENT_USER_ALREADY_BINDED =40008;
    public static  final int AGENT_USER_NOT_BINDED =40009;

    //代理商提现
    public static  final int AGENT_CANT_WITHDRAW =50001;
    public static  final int AGENT_WITHDRAW_OUTOFLIMIT =50002;
    public static  final int AGENT_WITHDRAW_MIN_LIMIT = 50003;

    //注册商户
    public static  final int MERCHANT_PHONE_EXIST =60001;
    public static  final int MERCHANT_REGISTER_ADD_MERCHANT_ERROR =60002;
    public static  final int MERCHANT_REGISTER_ADD_RESTAURANT_ERROR =60003;
    public static  final int MERCHANT_REGISTER_ADD_RESAURANTSTAFFERROR =60004;
    public static  final int MERCHANT_NOT_EXIST =60005;
    public static  final int MERCHANT_REGISTER_ADD_RESAURANTDEVICEERROR =60006;
    public static  final int MERCHANT_REGISTER_ADD_RESAURANTDEVICEIDEXIST =60007;

    public static  final int xx=123456;

}
