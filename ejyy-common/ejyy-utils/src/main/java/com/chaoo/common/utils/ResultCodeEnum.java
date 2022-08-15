package com.chaoo.common.utils;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 15:17
 *
 * 统一返回状态码之枚举版
 */
public enum ResultCodeEnum {
    SUCCESS(200, "系统初始化成功"),
    SYSTEMT_NOT_INIT(-66, "系统未初始化"),
    SYSTEMT_ALREADY_INIT(-78, "系统已经初始化了"),
    ACCOUNT_NOT_EXIST(-100, "账号不存在"),
    ACCOUNT_EXIST(-101, "账号存在"),
    CAPTCHA_ERROR(-102, "验证码错误"),
    NOT_LOGIN(-110, "未登录"),
    PWD_ERROR(-111, "密码错误"),
    PARAMS_ERROR(-112, "参数不合法"),
    WEHCAT_MP_LOGIN_ERROR(-113, "微信授权登录失败"),
    WEHCAT_MP_GET_PHONE_ERROR(-114, "微信回去手机号失败"),
    NOT_FOUND_BINDING_BUILDING(-115, "未查询到关联住宅信息"),
    QRCODE_ILLEGAL(-116, "二维码非法"),
    QRCODE_EXPIRED(-117, "二维码过期"),
    HAS_JOIN_EXPERIENCE(-118, "已经加入了家园体验"),
    COMMUNITY_ID_NOT_EXIST(-119, "社区不存在"),
    DATA_MODEL_UPDATE_FAIL(-120, "数据更新失败"),
    EXCEED_ALLOW_BINDING_CAR_NUMBER(-121, "需要绑定的车牌数量有限"),
    CAR_NUMBER_ALEADY_EXIST(-122, "车辆已绑定过"),
    UNBINDING_FAMILY_ILLEGAL(-123, "解绑家人情况非物业认证业主"),
    ACCOUNT_HAS_BEEN_FREEZE(-124, "账户被冻结"),
    SUBMIT_EXCEED_LIMIT(-125, "提交超过限制"),
    USER_NOT_BINDING_PHONE(-126, "用户未绑定手机号码"),
    IDCARD_ILLEGAL(-127, "身份证号非法没用到"),
    REMOTE_OPEN_DOOR_FAIL(-128, "远程开门失败"),
    REPAIR_RATE_EXIST(-129, "维修已经评论过"),
    QUERY_ILLEFAL(-130, "查询非法"),
    URGE_FAIL_ON_FINISH_REPAIR(-131, "维修催促 工单已完成"),
    EXCED_ALLOW_FREQUENCY(-132, "提交频次超限"),
    PAYMENT_CREATE_ORDER_FAIL(-133, "支付创建订单存在已支付或已创建的订单"),
    PAYMENT_BUILDING_ILLEGAL(-134, "创建支付订单的建筑id非法"),
    PAYMENT_CANCEL_ORDER_FAIL(-135, "取消订单失败"),
    STATUS_ERROR(-136, "状态错误"),
    FITMENT_CREATE_FAIL(-137, "装修报备已存在"),
    QUESTIONNAIRE_HAS_ANSWERED(-138, "问卷已答"),
    WECHAT_STATE_ILLEGAL(-139, "微信web登录授权码错误"),
    WEHCAT_WEB_LOGIN_FAIL(-140, "微信web登录失败"),
    COMPANY_INFO_EXIST(-141, "公司信息已经存在"),
    APPLY_COMPANY_REPEAT(-142, "每个人只能申请一家物业公司入驻"),
    ACCESS_DENY(-143, "权限错误"),
    DATA_MODEL_REMOVE_FAIL(-144, "数据删除失败"),
    VISTOR_QRCODE_ERROR(-145, "访客二维码错误"),
    VISTOR_QRCODE_EXPIRED(-146, "访客二维码过期"),
    VISTOR_QRCODE_USED(-147, "访客二维码使用了"),
    IMPORT_TEMPLATE_ERROR(-149, "导入模板粗错误"),
    ILLEGAL_PROPERTY_COMPANY_USER(-151, "非法的物业用户"),
    USER_INFO_UNINTACT(-152, "为完善身份信息"),
    MODEL_FIELD_VALUE_EXIST(-153, "数据库字段重复"),
    WORKFLOW_NOT_EXIST(-154, "不存在流程"),
    WORKFLOW_ILLEGAL(-155, "工作流非法"),
    MATERIAL_CATEGORY_EXIST(-156, "物品分类已经存在"),
    MATERIAL_EXIST(-157, "物品重复了"),
    STOREHOUSE_EXIST(-158, "仓库名称存在"),
    MATERIAL_SUPPLIER_EXIST(-158, "供货商存在"),
    MEETING_ROOM_EXIST(-159, "会议室存在"),
    MEETING_TIME_REPEAT(-160, "会议时间重复"),
    MISSION_CATEGORY_EXIST(-161, "任务类型存在"),
    MISSION_POINT_EXIST(-162, "任务点存在"),
    MISSION_LINE_EXIST(-163, "任务路线存在"),
    WORK_CHECK_NOT_EXIST(-164, "未配置考勤"),
    ENTRANCE_NAME_EXIST(-165, "门禁存在"),
    ELEVATOR_NAME_EXIST(-166, "梯控存在"),
    LAMP_NAME_EXIST(-167, "灯控存在"),
    LAMP_LINE_NAME_EXIST(-168, "灯控线路存在"),
    REPEATER_NAME_EXIST(-169, "中继器名称存在"),
    METER_NAME_EXIST(-170, "仪表名称存在"),
    PARK_NAME_EXIST(-171, "停车场名称存在"),
    PARK_BLACKLIST_EXIST(-172, "黑名单存在"),
    WARNING_NAME_EXIST(-173, "预警中控名称存在"),
    IOT_ENTRANCE_ILLEGAL(-174, "门禁非法"),
    IOT_ELEVATOR_ILLEGAL(-175, "梯控非法"),
    IOT_LAMP_ILLEGAL(-176, "灯控非法"),
    IOT_REPEATER_ILLEGAL(-177, "中继器非法"),
    IOT_METER_ILLEGAL(-178, "仪表非法"),
    IOT_PARK_ILLEGAL(-179, "停车差非法"),
    IOT_WARNING_ILLEGAL(-180, "预警中控非法"),
    IOT_SECRET_ERROR(-181, "物联网设备秘钥错误");

    private final Integer code;

    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}