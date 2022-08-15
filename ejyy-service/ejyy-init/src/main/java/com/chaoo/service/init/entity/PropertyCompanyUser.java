package com.chaoo.service.init.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyCompanyUser implements Serializable {
    private Integer id;
    private String account;
    private String password;
    private String openId;
    private String unionId;
    private String realName;
    private String idcard;
    private boolean gender;
    private String avatarUrl = "/avatar/default.png";
    private String phone;
    private Long departmentId;
    private Long jobId;
    private Long accessId;
    private boolean admin;
    private Long joinCompanyAt;
    private boolean leaveOffice;
    private Long createdBy;
    private Long createdAt;
}