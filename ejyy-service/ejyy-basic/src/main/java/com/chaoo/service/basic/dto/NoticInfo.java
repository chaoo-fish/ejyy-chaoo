package com.chaoo.service.basic.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/16/ 19:14
 * <p>
 * 接收前端传来的通知
 */
@Data
public class NoticInfo {
    private Long user_id;
    private String title; // "通知标题",
    private String overview; //  "通知概述",
    private Integer published; //  1是发布
    private Boolean oa_tpl_msg; // :false,

    private String tpl; // : "",
    private String tpl_content; // : [],

    private String content; //
    private Long community_id; //  3
}
