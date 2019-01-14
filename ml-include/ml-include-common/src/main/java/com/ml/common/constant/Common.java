package com.ml.common.constant;

/**
 * 公共常量
 */
public class Common {
    public static final String JWT_KEY_CODE = "code";
    public static final String JWT_KEY_NAME = "name";
    public static final String JWT_KEY_TIME = "time";

    /**
     * 门店Code
     */
    public static final String SHOP_CODE_KEY = "constant:shop_code";

    /**
     * 微信token
     */
    public static final String WX_SESSION_KEY = "wx:sessionKey:";

    public static final String USER_LOGIN_HY_TOKEN = "user:login:hy:token:";

    public static final String USER_LOGIN_HY_ID = "user:login:hy:id:";

    public static final String USER_LOGIN_DY_TOKEN = "user:login:dy:token:";

    public static final String USER_LOGIN_DY_ID = "user:login:dy:id:";

    /**
     * 会员等级key
     */
    public static final String MEMBER_LEVEL_KEY = "westore-memeber-level";


    /**
     * 商品条码Key
     */
    public static final String GOODS_SN = "westore-goodsSn:";

    /**
     * 商品状态 - 字典Tag
     */
    public static final String PUB_ITEM_STATUS_TAG = "PUB_ITEM_STATUS";

    /**
     * 调拨单状态 - 已完成
     */
    public static final String PUB_MOVE_DOC_STATUS = "3";

    /**
     * 删除标志 1正常 , 0 删除
     */
    public static final Byte D_FLAG_NORMAL = 1;

    /**
     * 删除标志 1正常 , 0 删除
     */
    public static final Byte D_FLAG_INVALID = 0;

    /**
     * 采购状态 1 待发货 , 3 已发货 4 部分到货 , 5 有差异 , 6 全部到货
     */
    public static final Byte PUB_DOC_DELIVERY_WAIT = 1;

    public static final Byte PUB_DOC_DELIVERY_SEND_PART = 2;

    public static final Byte PUB_DOC_DELIVERY_YET = 3;

    public static final Byte PUB_DOC_DELIVERY_PART = 4;

    public static final Byte PUB_DOC_DELIVERY_DIFF = 5;

    public static final Byte PUB_DOC_DELIVERY_ALL = 6;

    //5-拒收, 6-已收货,7-收货差异,4待收货,1-待发货
    public static final Byte PUB_DELIVERY_REJ_RECV = 5;

    public static final Byte PUB_DELIVERY_CHK_RECV = 6;

    public static final Byte PUB_DELIVERY_CHK_DEF = 7;

    public static final Byte PUB_DELIVERY_PRE_RECV = 4;

    public static final Byte PUB_DELIVERY_PRE_SEND = 1;

    public static final Byte PROC_STATUS_ORDEERED = 1;

    /**
     * 查询用户店铺信息缓存
     */
    public static final String SYS_USER_DEPT = "SYS_USER_DEPT";

    /**
     * 查询机构信息缓存
     */
    public static final String SYS_USER_DEPT_BRANCH = "SYS_USER_DEPT_BRANCH";

    public static final String SYS_USER_BRANCH_STORAGE = "SYS_USER_BRANCH_STORAGE";

    public static final String SYS_SHOP_BRANCH = "SYS_SHOP_BRANCH";

    /**
     * 查询用户仓库信息缓存
     */
    public static final String SYS_USER_STORAGE = "SYS_USER_STORAGE";

    /********************************短信模板code**************************************/

    public static final String SYS_MSG_BIZ_CODE_CUSTOMER_BIND_MOBILE = "customer_bind_mobile";

    public static final String SYS_MSG_BIZ_CODE_CUSTOMER_REGISTER = "customer_register";

    public static final String SYS_MSG_BIZ_CODE_SALESORDER_PAYSTAT_FOUR = "salesorder_paystat_4";

    //审核同意
    public static final Byte AUDIT_APPROVAL = 2;
    //审核拒绝
    public static final Byte AUDIT_REJECT = 4;

    public static final Byte AP_EST_FLAG_YES = 1 ;

    public static final Byte AP_EST_FLAG_NO = 0 ;

    public static final Byte AP_EST_FLAG_PART = 2 ;

    //商品状态
    public static final Byte ITEM_STATE_NEW = 1;

    public static final Byte ITEM_STATE_TEST = 2;

    public static final Byte ITEM_STATE_NORMAL = 3;

    public static final Byte ITEM_STATE_ONE_TIME = 4;


    //采购退货审核同意
    public static final Byte RETURN_AUDIT_APPROVAL = 3;
    //采购退货审核拒绝
    public static final Byte RETURN_AUDIT_REJECT = 2;

    //仓库启用状态
    public static final Byte USABLE_STORAGE = 2;
    //退货仓库状态
    public static final Byte IS_RETURN_STORAGE = 1;
}


