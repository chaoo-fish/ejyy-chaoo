package com.chaoo.service.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公司和小区
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyCompanyUserDefaultCommunity implements Serializable {
    private Long id;
    private Long property_company_user_id; // 公司编号
    private Long community_id; // 小区编号
}
