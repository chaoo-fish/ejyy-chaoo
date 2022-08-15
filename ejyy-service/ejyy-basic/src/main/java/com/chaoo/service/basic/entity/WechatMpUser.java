package com.chaoo.service.basic.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WechatMpUser implements Serializable {

    private Long id;

    private String openId;

    private String unionId;

    private String nickName;

    private String realName;

    private String idcard;

    private String phone;

    private String avatarUrl;

    /**
     * 1 男 2女
     */
    private Boolean gender;

    private String signature;

    /**
     * 0 身份信息未补全; 1补全
     */
    private Integer intact;

    private Long createdAt;


}