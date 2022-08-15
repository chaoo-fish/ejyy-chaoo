package com.chaoo.service.init.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 11:51
 * <p>
 * 接收初始化参数的对象
 */
@Data
public class ParamDto {
    // 小区
    private String name; // 小区名称
    private String banner; // 小区照片
    private String province; // 小区所在省
    private String city; // 小区所在市
    private String district; // 小区所在区
    private String service_phone; // 服务电话
    private boolean access_nfc; // 是否开启NFC门禁
    private boolean access_remote; // 是否开启远程开门
    private boolean access_qrcode; // 是否开启二维码门禁
    private int carport_max_car; // 车位绑定车辆数目
    private boolean fitment_pledge; // 装修保证金
    // 个人
    private String account; // 账号
    private String password; // 密码
    private String real_name; // 姓名
    private String avatar_url; // 头像
    private String phone; // 手机号码
    private String idcard; // 身份证号码
    // 微信
    private String code; // 微信号
    private String state; // 状态
}
