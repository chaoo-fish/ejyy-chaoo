package com.chaoo.service.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录参数
 */
@Data
public class LoginParam implements Serializable {
    private String account; // 账号
    private String password; // 密码
    private String captcha; // 验证码
}
