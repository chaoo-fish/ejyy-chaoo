package com.chaoo.service.user.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 10:52
 *
 * 返回给前端的用户信息
 */
@Data
@Builder
public class UserInfo implements Serializable {
    private Integer id;
    private String account;
    private String open_id;
    private String real_name;
    private Integer gender;
    private String avatar_url;
    private String phone;
    private Long join_company_at;
    private Integer admin;
    private Long created_at;
    private Integer subscribed; // 从类型 boolean 改为 Integer
    private String access;
}