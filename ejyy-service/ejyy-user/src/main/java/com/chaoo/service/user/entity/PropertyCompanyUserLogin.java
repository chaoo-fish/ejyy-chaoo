package com.chaoo.service.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    private Long propertyCompanyUserId; // 个人信息的编号
    private String ip; // 登录 IP
    private String userAgent; // 登录浏览器信息
    private Long loginAt; // 登陆时间
}