package com.chaoo.common.utils;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 11:07
 *
 * 状态码
 */
public class ResultCode {
    /* http 状态码 */
    public static final int SUCCESS = 200;
    /* 系统未初始化 */
    public static final int SYSTEMT_NOT_INIT = -66;
    /* 系统已经初始化了 */
    public static final int SYSTEMT_ALREADY_INIT = -78;
    /* 账号不存在 */
    public static final int ACCOUNT_NOT_EXIST = -100;
    /* 账号存在 */
    public static final int ACCOUNT_EXIST = -101;
    /* 验证码错误 */
    public static final int CAPTCHA_ERROR = -102;
    /* 未登录 */
    public static final int NOT_LOGIN = -110;
    /* 密码错误 */
    public static final int PWD_ERROR = -111;
    /* 参数错误 */
    public static final int PARAMS_ERROR = -112;
    /* 微信授权登录失败 */
    public static final int WEHCAT_MP_LOGIN_ERROR = -113;
    /* 微信回去手机号失败 */
    public static final int WEHCAT_MP_GET_PHONE_ERROR = -114;
    /* 未查询到关联住宅信息 */
    public static final int NOT_FOUND_BINDING_BUILDING = -115;
    /* 二维码非法 */
    public static final int QRCODE_ILLEGAL = -116;
    /* 二维码过期 */
    public static final int QRCODE_EXPIRED = -117;
    /* 已经加入了家园体验 */
    public static final int HAS_JOIN_EXPERIENCE = -118;
    /* 社区不存在 */
    public static final int COMMUNITY_ID_NOT_EXIST = -119;
    /* 数据更新失败 */
    public static final int DATA_MODEL_UPDATE_FAIL = -120;
    /* 需要绑定的车牌数量有限 */
    public static final int EXCEED_ALLOW_BINDING_CAR_NUMBER = -121;
    /* 车辆已绑定过 */
    public static final int CAR_NUMBER_ALEADY_EXIST = -122;
    /* 解绑家人情况非物业认证业主 */
    public static final int UNBINDING_FAMILY_ILLEGAL = -123;
    /* 账户被冻结 */
    public static final int ACCOUNT_HAS_BEEN_FREEZE = -124;
    /* 提交超过限制 */
    public static final int SUBMIT_EXCEED_LIMIT = -125;
    /* 用户未绑定手机号码 */
    public static final int USER_NOT_BINDING_PHONE = -126;
    /* 身份证号非法 没用到 */
    public static final int IDCARD_ILLEGAL = -127;
    /* 远程开门失败 */
    public static final int REMOTE_OPEN_DOOR_FAIL = -128;
    /* 维修已经评论过 */
    public static final int REPAIR_RATE_EXIST = -129;
    /* 查询非法 对应查询 detail */
    public static final int QUERY_ILLEFAL = -130;
    /* 维修催促 工单已完成 */
    public static final int URGE_FAIL_ON_FINISH_REPAIR = -131;
    /* 提交频次超限 */
    public static final int EXCED_ALLOW_FREQUENCY = -132;
    /* 支付创建订单存在已支付或已创建的订单 */
    public static final int PAYMENT_CREATE_ORDER_FAIL = -133;
    /* 创建支付订单的建筑id非法，也就不是自己的 */
    public static final int PAYMENT_BUILDING_ILLEGAL = -134;
    /* 取消订单失败 */
    public static final int PAYMENT_CANCEL_ORDER_FAIL = -135;
    /* 状态错误 */
    public static final int STATUS_ERROR = -136;
    /* 装修报备已存在 */
    public static final int FITMENT_CREATE_FAIL = -137;
    /* 问卷已答 */
    public static final int QUESTIONNAIRE_HAS_ANSWERED = -138;
    /* 微信web登录授权码错误 */
    public static final int WECHAT_STATE_ILLEGAL = -139;
    /* 微信web登录失败 */
    public static final int WEHCAT_WEB_LOGIN_FAIL = -140;
    /* 公司信息已经存在 */
    public static final int COMPANY_INFO_EXIST = -141;
    /* 每个人只能申请一家物业公司入驻 */
    public static final int APPLY_COMPANY_REPEAT = -142;
    /* 权限错误 */
    public static final int ACCESS_DENY = -143;
    /* 数据删除失败 */
    public static final int DATA_MODEL_REMOVE_FAIL = -144;
    /* 访客二维码错误 */
    public static final int VISTOR_QRCODE_ERROR = -145;
    /* 访客二维码过期 */
    public static final int VISTOR_QRCODE_EXPIRED = -146;
    /* 访客二维码使用了 */
    public static final int VISTOR_QRCODE_USED = -147;
    /* 导入模板粗错误 */
    public static final int IMPORT_TEMPLATE_ERROR = -149;
    /* 非法的物业用户 */
    public static final int ILLEGAL_PROPERTY_COMPANY_USER = -151;
    /* 为完善身份信息 */
    public static final int USER_INFO_UNINTACT = -152;
    /* 数据库字段重复 */
    public static final int MODEL_FIELD_VALUE_EXIST = -153;
    /* 不存在流程 */
    public static final int WORKFLOW_NOT_EXIST = -154;
    /* 工作流非法 */
    public static final int WORKFLOW_ILLEGAL = -155;
    /* 物品分类已经存在 */
    public static final int MATERIAL_CATEGORY_EXIST = -156;
    /* 物品重复了 */
    public static final int MATERIAL_EXIST = -157;
    /* 仓库名称存在 */
    public static final int STOREHOUSE_EXIST = -158;
    /* 供货商存在 */
    public static final int MATERIAL_SUPPLIER_EXIST = -158;
    /* 会议室存在 */
    public static final int MEETING_ROOM_EXIST = -159;
    /* 会议时间重复 */
    public static final int MEETING_TIME_REPEAT = -160;
    /* 任务类型存在 */
    public static final int MISSION_CATEGORY_EXIST = -161;
    /* 任务点存在 */
    public static final int MISSION_POINT_EXIST = -162;
    /* 任务路线存在 */
    public static final int MISSION_LINE_EXIST = -163;
    /* 未配置考勤 */
    public static final int WORK_CHECK_NOT_EXIST = -164;
    /* 门禁存在 */
    public static final int ENTRANCE_NAME_EXIST = -165;
    /* 梯控存在 */
    public static final int ELEVATOR_NAME_EXIST = -166;
    /* 灯控存在 */
    public static final int LAMP_NAME_EXIST = -167;
    /* 灯控线路存在 */
    public static final int LAMP_LINE_NAME_EXIST = -168;
    /* 中继器名称存在 */
    public static final int REPEATER_NAME_EXIST = -169;
    /* 仪表名称存在 */
    public static final int METER_NAME_EXIST = -170;
    /* 停车场名称存在 */
    public static final int PARK_NAME_EXIST = -171;
    /* 黑名单存在 */
    public static final int PARK_BLACKLIST_EXIST = -172;
    /* 预警中控名称存在 */
    public static final int WARNING_NAME_EXIST = -173;
    /* 门禁非法 */
    public static final int IOT_ENTRANCE_ILLEGAL = -174;
    /* 梯控非法 */
    public static final int IOT_ELEVATOR_ILLEGAL = -175;
    /* 灯控非法 */
    public static final int IOT_LAMP_ILLEGAL = -176;
    /* 中继器非法 */
    public static final int IOT_REPEATER_ILLEGAL = -177;
    /* 仪表非法 */
    public static final int IOT_METER_ILLEGAL = -178;
    /* 停车差非法 */
    public static final int IOT_PARK_ILLEGAL = -179;
    /* 预警中控非法 */
    public static final int IOT_WARNING_ILLEGAL = -180;
    /* 物联网设备秘钥错误 */
    public static final int IOT_SECRET_ERROR = -181;
}
