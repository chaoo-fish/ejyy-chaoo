package com.chaoo.service.user.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 10:52
 *
 * 登录成功后的信息
 */
@Data
@Builder
public class LoginInfo implements Serializable {
    private Integer id;
    private String account;
    private String password;
    private String openId;
    private String realName;
    private boolean gender;
    private String avatarUrl;
    private String phone;
    private Long departmentId;
    private Long jobId;

    private Long joinCompanyAt;
    private boolean admin;
    private Long createdAt; // 创建时间

    private Integer subscribed; // 这里改为 Integer,因为表中这个字段值为 null,它不能赋给 boolean 类型的变量
    private String content;
}
