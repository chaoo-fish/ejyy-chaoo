package com.chaoo.service.basic.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WechatMpUser implements Serializable {

    private Long id;

    private String open_id;

    private String union_id;

    private String nick_name;

    private String real_name;

    private String idcard;

    private String phone;

    private String avatar_url;

    /**
     * 1 男 2女
     */
    private Boolean gender;

    private String signature;

    /**
     * 0 身份信息未补全; 1补全
     */
    private Integer intact;

    private Long created_at;


}