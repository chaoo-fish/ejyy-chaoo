package com.chaoo.service.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 投诉模块
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complain implements Serializable {
    private Long id;
    private Long community_id;
    private Integer type;
    private Long wechat_mp_user_id;
    private Long property_company_user_id;
    /**
     * 1 卫生问题;2 噪音问题;3 服务态度;4 违建; 5 占用消防通道; 6 社区设施; 7 其他
     */
    private Integer category;
    private String description;
    private String complain_imgs;
    private Integer dispose_subscribed;
    private Integer confrim_subscribed;
    private Integer finish_subscribed;
    private Long allot_user_id;
    private Long alloted_at;
    private Long dispose_user_id;
    private String dispose_reply;
    private String dispose_content;
    private String dispose_imgs;
    private Long disposed_at;
    private Long finished_at;
    private Long merge_id;
    private Integer step;
    private Integer rate;
    private String rate_content;
    private Long rated_at;
    private Long created_at;
}