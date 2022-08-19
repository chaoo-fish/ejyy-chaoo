package com.chaoo.service.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 小区信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityInfo implements Serializable {
    private Long id;
    private String name; // 小区名称
    private String banner; // 小区照片
    private String province; // 小区所在省
    private String city; // 小区所在市
    private String district; // 小区所在区
    private String phone; // 客服电话
    private Long created_at; // 创建时间
    private Long created_by; // 创建人
}