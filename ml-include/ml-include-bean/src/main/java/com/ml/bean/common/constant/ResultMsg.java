package com.ml.bean.common.constant;


import com.ml.bean.common.util.CodeEnum;

public enum ResultMsg implements CodeEnum {

    SUCCESS("S0000", "操作成功"),

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
    USER_CONSIGNEEID_COORDINATE("S0023", "用户收获地址坐标信息不存在"),
    SUPPLIERID_IS_NULL("S0024", "供应商ID为空"),
    USERCONSIGNEE_IS_NULL("S0025", "无法获取收货人信息或者收货人经纬度信息"),
    MINIMUMLIST_ERROR("S0026", "调用仓库距离信息接口异常"),
    ONLINECHKSTOCK_ERROR("S0027", "调用库存余量接口异常"),
    SHELF_ADD_ERROR_SHOPID_NULL("S9000", "用户未与店铺关联"),
    SHELF_ADD_ERROR_IMAGE_NULL("S90001", "货架图标为空，请上传图标"),
    GOODS_SHELF_INFO_IS_NULL("S90001", "货架信息不存在"),
    MEMBER_LEVEL_ERROR_IMAGE_NULL("S90001", "会员图标为空，请上传图标"),
    NO_UP_MOVE("S70001", "不能向上移动"),
    NO_DOWN_MOVE("S70002", "不能向下移动"),
    STORAGE_REVOKE("S70003", "该仓库对应门店为非撤销状态"),
    SMS_SEND_FAIL("S70004", "短信发送失败"),
    SMS_SEND_ERROR("S70005", "短信发送异常"),
    PICK_VERIFY_CODE_ERROR("S70006", "提货验证码错误"),

    EFFECTIVE_TIME_REPET("S70007", "优惠券持续时间和有效天数错误"),
    TICKET_TIME_ERROR("S70008", "优惠券持续时间或有效天数为空"),
    ACTION_NOT_FOUND_RESULT("S70009", "未找到优惠券对应活动"),
    TICKET_DISCOUNT_ERROR("S70010", "优惠券折扣应在0-1之间"),
    TICKET_AMOUNT_ERROR("S70011", "优惠券总金额大于活动预算金额"),
    TICKET_TIME_LOGIC_ERROR("S70012", "优惠券开始时间大于优惠券结束时间"),


    USER_NOT_EXISTS("S70000", "用户不存在"),
    MOBILE_NOT_EXISTS("S70028", "手机号不存在"),
    MOBILE_FORMAT_ERROR("S70010", "手机号格式错误"),
    VIP_ACCOUNT_PWD_ERROR("S70011", "账号或密码不正确"),
    CODE_IMG_NULL("S70012", "图片验证码为空"),
    PWD_NULL("S70013", "密码不能为空"),
    TOKEN_NULL("S70014", "token不能为空"),
    TOKEN_ERROR("S70015", "token不正确"),
    SMS_CODE_ERROR("S70016", "短信验证码错误"),
    SMS_CODE_NULL("S70017", "短信验证码不能为空"),
    SMS_OPT_NULL("S70018", "短信发送操作来源为空"),
    SMS_OPT_ERROR("S70019", "短信发送操作来源错误"),
    IMG_CODE_OPT_NULL("S70020", "图片验证码操作来源不能为空"),
    IMG_CODE_OPT_ERROR("S70021", "图片验证码操作来源错误"),
    IMG_CODE_ERROR("S70022", "图片验证码错误"),
    MOBILE_IS_NOT_REGIST("S70023", "手机号未注册"),
    MOBILE_IS_REGIST("S70029", "手机号已注册"),
    PWD_FORMAT_ERROR("S70024", "密码格式错误"),
    PHONE_EXIST_MULIT_ERROR("S70026", "该手机号存在多条数据"),
    APP_SYSTEM_SYS_BRANCH_CODE_EXIST("S", "机构代码已存在"),
    PWD_UPDATE_ERROR("S70027", "忘记密码的密码更新失败"),

    STOCK_ITEM_NO_ENOUGH("S70025", "库存不够"),
    ENTER_RIGHT_TIME("S70026", "请输入正确的开始或结束时间"),
    START_DATE_GRATER_END_DATE("S70030", "开始时间不能大于结束时间"),
    STOCK_ITEM_DEDUCTION("S70031", "已扣减"),
    PHONE_ISNOT_EFFECT("S70032", "手机号已被冻结"),
    STOCK_ITEM_DUPLICATE("S70033", "采购入库存在重复数据"),
    /******** market start **********/
    PACKAGE_SN_NULL("S70100", "礼包条码不能为空"),
    PACKAGE_IMG_NULL("S70101", "礼包图片不能为空"),
    AUDIT_STATUS_ERROR("S70102", "审核状态错误"),
    AUDIT_REFUSE_REASON_NULL("S70103", "审核拒绝原因不能为空"),
    PACKAGE_ID_NULL("S70104", "大礼包主键不能为空"),
    PAUSE_AUDIT_ERROR("S70105", "暂停启动大礼包参数不对"),
    ACTIVE_END_CANTNOT_OPT("S70106", "活动已结束，不可操作"),
    CONDITION_VALUE_ERROR("S70107", "参与条件值错误"),
    CONDITION_TYPE_ERROR("S70108", "参与条件类型错误"),
    PRIMARY_KEY_NULL("S70109", "主键不能为空"),
    GOODS_SN_NULL("S70110", "商品条码不能为空"),
    CONDITION_HAS_NO_DATA("S70111", "请为大礼包添加参与条件"),
    ITEM_HAS_NO_DATA("S70112", "请为大礼包添加商品"),
    VERIFY_CANNOT_OPT("S70113", "不是待审核状态，不可审核操作"),
    PACKAGE_TO_GOOGS_ERROR("S70114", "添加大礼包到商品失败"),
    QUERY_SUBDIVS_ERROR("S70115", "查询子商品分类失败"),
    INVALID_PACKAGEID("S70116", "无效大礼包ID"),
    START_DATE_IS_NULL("S70117", "开始时间不能为空"),
    END_DATE_IS_NULL("S70118", "结束时间不能为空"),
    PACKAGE_EFFACTIVE("S70119", "大礼包活动有效"),
    PACKAGE_INVALID("S70120", "大礼包活动无效"),
    IMG_SO_BIG("S70121", "图片超过2M"),
    PAUSE_PARMA_ERROR("S70122", "大礼包暂停参数错误"),
    GOOD_DISPRICE_NULL("S70123", "商品折让价不能为空"),
    GOOD_COUNT_NULL("S70124", "商品数量不能为空"),
    SKUID_IN_THIS_PACKAGE("S70125", "大礼包已存在该商品"),
    ADD_PACKAGE_TO_SHOP_ERROR("S70126", "大礼包添加到商铺失败"),
    PACAGE_CONDITION_INVALID("S70127", "大礼包会员无效"),
    PACAGE_CONDITION_EFFACTIVE("S70126", "大礼包会员有效"),
    PACKAGE_ITEM_INVALID("S70127", "礼包商品有无效商品"),
    PACKAGE_NOFOUND_ITEM("S70128", "没有找到礼包有效商品"),
    PACKAGE_NO_FOUND_BY_ITEMS("S70129", "没有找到对应的大礼包"),
    PACKAGE_STATUS_ERROR("S70129", "无效大礼包状态"),
    /******** market end **********/
    IMG_STR_NULL("S710150", "图片不能为空"),
    FILE_IS_NULL("S710151", "上传文件不能为空"),

    GET_SHOPID_NULL("S710155", "获取店铺ID失败"),
    FAIL("S9999", "操作失败");

    private String code;
    private String name;

    ResultMsg(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
