package com.ml.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回码
 */
public abstract class ResCode {

    public static Map<String, String> mapCommon = new HashMap<String, String>();

    // 系统鉴权返回码前缀
    public final static String APP_SYSTEM_AUTH = "31";
    // 用户中心返回码前缀
    public final static String APP_USER_CENTER = "32";
    // 系统中心中心返回码前缀
    public final static String APP_SYSTEM_SYS = "33";


    // 公用返回码
    // 成功
    public final static String COMN_SUCCESS = "00000";
    // 失败
    public final static String COMN_ANOMALY = "90000";
    // 应用未授权
    public final static String COMN_APP_NOT_AUTH = "01001";
    // 访问令牌无效
    public final static String COMN_ACCESS_TOKEN_INVALID = "01002";
    // 访问令牌过期
    public final static String COMN_ACCESS_TOKEN_EXPIRATION = "01003";
    // 刷新令牌无效
    public final static String COMN_REFRESH_TOKEN_INVALID = "01004";
    // 刷新令牌过期
    public final static String COMN_REFRESH_TOKEN_EXPIRATION = "01005";
    // 请求认证超过限制次数
    public final static String COMN_OVER_AUTH_LIMIT = "01006";
    // 应用验证失败
    public final static String COMN_APP_VERIFY_FAILED = "01007";
    // IP受限
    public final static String COMN_APP_IP_LIMITED = "01008";
    // sendTime为空
    public final static String COMN_APP_SENDTIME_NULL = "01008";

    // 系统鉴权返回码
    public static Map<String, String> mapSystemAuth = new HashMap<String, String>();
    // 用户未登录
    public final static String APP_SYSTEM_AUTH_NOT_LOGIN = APP_SYSTEM_AUTH + "101";
    // 用户无权限
    public final static String APP_SYSTEM_AUTH_NO_RIGHT = APP_SYSTEM_AUTH + "301";

    // 用户中心返回码
    public static Map<String, String> mapUserCenter = new HashMap<String, String>();
    // 用户未登录
    public final static String APP_USER_CENTER_NOT_LOGIN = APP_USER_CENTER + "101";
    // 用户无权限
    public final static String APP_USER_CENTER_NO_RIGHT = APP_USER_CENTER + "301";
    // 用户参数为空
    public final static String APP_USER_CENTER_PARAM_NULL_PHONE = APP_USER_CENTER + "401";
    public final static String APP_USER_CENTER_PARAM_NULL_PWD= APP_USER_CENTER + "402";
    public final static String APP_USER_CENTER_PARAM_PHONE_ERROE = APP_USER_CENTER + "403";
    public final static String APP_USER_CENTER_PARAM_ID_CARD_ERROR = APP_USER_CENTER + "404";
    public final static String APP_USER_CENTER_PHONE_CODE_BINDING = APP_USER_CENTER + "405";
    public final static String APP_USER_CENTER_PWD_ERROR = APP_USER_CENTER + "417";
    public final static String APP_USER_CENTER_STATUS_FORBIDDEN = APP_USER_CENTER + "420";
    public final static String APP_USER_CENTER_BORROWER_NULL = APP_USER_CENTER + "410";
    public final static String APP_USER_CENTER_PARAM_NULL_APP_KEY = APP_USER_CENTER + "411";
    public final static String APP_USER_CENTER_PARAM_NULL_ID_CARD = APP_USER_CENTER + "412";


    // 系统中心返回码
    public static Map<String, String> systemCenter = new HashMap<String, String>();
    public final static String APP_SYSTEM_SYS_BRANCH_PARAM = APP_SYSTEM_SYS + "001";
    public final static String APP_SYSTEM_SYS_BRANCH_NOT_FOUND = APP_SYSTEM_SYS + "002";
    public final static String APP_SYSTEM_SYS_BRANCH_STATUS_ERR = APP_SYSTEM_SYS + "003";
    static {
        // 公用返回码
        mapCommon.put(COMN_SUCCESS, "操作成功。");
        mapCommon.put(COMN_ANOMALY, "操作失败，请重试操作或联系客服人员！");
        mapCommon.put(COMN_APP_NOT_AUTH, "请先取得授权！");
        mapCommon.put(COMN_ACCESS_TOKEN_INVALID, "访问令牌无效。");
        mapCommon.put(COMN_ACCESS_TOKEN_EXPIRATION, "访问令牌过期。");
        mapCommon.put(COMN_REFRESH_TOKEN_INVALID, "刷新令牌无效。");
        mapCommon.put(COMN_REFRESH_TOKEN_EXPIRATION, "刷新令牌过期。");
        mapCommon.put(COMN_OVER_AUTH_LIMIT, "请求认证超过限制次数。");
        mapCommon.put(COMN_APP_VERIFY_FAILED, "应用验证失败。");
        mapCommon.put(COMN_APP_IP_LIMITED, "IP受限。");
        mapCommon.put(COMN_APP_SENDTIME_NULL, "sendTime不能为空。");

        // 系统鉴权返回码
        mapSystemAuth.put(APP_SYSTEM_AUTH_NOT_LOGIN, "用户未登录。");
        mapSystemAuth.put(APP_SYSTEM_AUTH_NO_RIGHT, "用户无权限。");

        // 用户中心返回码
        mapUserCenter.put(APP_USER_CENTER_NOT_LOGIN, "用户未登录。");
        mapUserCenter.put(APP_USER_CENTER_NO_RIGHT, "用户无权限。");
        mapUserCenter.put(APP_USER_CENTER_PARAM_NULL_PHONE, "phone 不能为空");
        mapUserCenter.put(APP_USER_CENTER_PARAM_NULL_PWD, "password 不能为空");
        mapUserCenter.put(APP_USER_CENTER_PARAM_PHONE_ERROE, "手机号码格式错误");
        mapUserCenter.put(APP_USER_CENTER_PARAM_ID_CARD_ERROR, "身份证号码格式错误");
        mapUserCenter.put(APP_USER_CENTER_PHONE_CODE_BINDING, "手机设备号已绑定");
        mapUserCenter.put(APP_USER_CENTER_PWD_ERROR, "密码有误，请重新输入");
        mapUserCenter.put(APP_USER_CENTER_STATUS_FORBIDDEN, "用户被禁用");
        mapUserCenter.put(APP_USER_CENTER_BORROWER_NULL, "账户不存在");
        mapUserCenter.put(APP_USER_CENTER_PARAM_NULL_APP_KEY, "appKey 不能为空");
        mapUserCenter.put(APP_USER_CENTER_PARAM_NULL_ID_CARD, "idCard 不能为空");

        //系统中心返回码
        systemCenter.put(APP_SYSTEM_SYS_BRANCH_PARAM,"参数不能为空");
        systemCenter.put(APP_SYSTEM_SYS_BRANCH_NOT_FOUND,"机构不存在");
        systemCenter.put(APP_SYSTEM_SYS_BRANCH_STATUS_ERR,"机构状态不正确");
    }
}
