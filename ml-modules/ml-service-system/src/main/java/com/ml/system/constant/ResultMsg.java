package com.ml.system.constant;

/**
 * 返回信息枚举类
 *
 * @author liangzhong
 * @version 1.0
 * @date 2018/12/1
 */
public enum ResultMsg {

    /**
     * 操作成功
     */
    SUCCESS("S0000", "操作成功"),
    FAIL("S9999", "操作失败"),
    ERROR("E0000", "系统异常"),
    NOT_LOGIN("S0001", "未登录"),
    LOGIN_FAIL("S0002", "登录失败"),
    NOT_AUTH("S0003", "访问受限"),
    PARAM_IS_ERROR("S0004", "参数错误"),
    PARAM_IS_NULL("S0005", "参数为空"),
    IS_EXIST("S0006", "数据已存在"),
    NOT_FOUND_RESULT("S0007", "没有找到记录"),
    PARAM_IS_TO_BIG("S0008", "参数过大,请保持在规定范围"),
    SAVE_FAIL("S0009", "保存失败"),
    MODIFY_FAIL("S0010", "修改失败"),
    SAVE_OR_MODIFY_FAIL("S0011", "保存或修改失败"),
    DELETE_FAIL("S0012", "删除失败"),
    INVALID_DATA("S0013", "无效数据"),
    ALREADY_EXPIRATION("S0014", "已经过期"),
    NOT_PARAM("S0015", "缺少参数"),
    CHECK_CONFIG("S0016", "请检查配置"),
    TOO_MANY_REQUESTS("S0017", "请求太多"),
    PARAM_STOCK_IN_COUNT_ERROR("S0018", "入库数量错误"),
    PARAM_STOCK_OUT_COUNT_ERROR("S0019", "退库数量错误"),
    STORE_MARKET_NOT_FOUND_RESULT("S0020", "没有找到店铺信息"),
    USERNAME_OR_PASSWORD_ERROR("S0021", "用户名或密码错误"),
    USER_UNRELATED_STOREINFO("S0022", "用户无关联店铺信息"),
    SHELF_ADD_ERROR_SHOPID_NULL("S9000", "用户未与店铺关联"),
    SHELF_ADD_ERROR_IMAGE_NULL("S90001", "货架图标为空，请上传图标"),
    GOODS_SHELF_INFO_IS_NULL("S90001", "货架信息不存在"),
    MEMBER_LEVEL_ERROR_IMAGE_NULL("S90001", "会员图标为空，请上传图标"),
    ;

    private String code;
    private String name;

    ResultMsg(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
