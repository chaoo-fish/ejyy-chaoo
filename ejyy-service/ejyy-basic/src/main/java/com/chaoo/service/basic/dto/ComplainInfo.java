package com.chaoo.service.basic.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/17/ 13:35
 *
 * 接受前端的投诉消息
 */
@Data
public class ComplainInfo {
    private Integer wechat_mp_user_id;
    private Integer type;
    private Integer category;
    private Long community_id;
    private String description;
    private String complain_imgs;
}
