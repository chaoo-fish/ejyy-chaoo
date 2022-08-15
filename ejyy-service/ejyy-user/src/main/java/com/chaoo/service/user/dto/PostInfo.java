package com.chaoo.service.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户部门和职位信息传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostInfo implements Serializable {
    private String department; // 部门名称
    private String job; // 职位名称
    private List<CommunityList> community_list = new ArrayList<>();
    private Long default_community_id; // 默认小区编号
    private Integer wechat_payment;
}