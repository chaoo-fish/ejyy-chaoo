package com.chaoo.service.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 个人登录的日志表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyCompanyUserLogin implements Serializable {
    private Integer id;
    private Long property_company_user_id; // 个人信息的编号
    private String ip; // 登录 IP
    private String user_agent; // 登录浏览器信息
    private Long login_at; // 登陆时间
}