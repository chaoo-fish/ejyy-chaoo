package com.chaoo.service.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 个人令牌和公司中间
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyCompanyAuth implements Serializable {
    private Long id;
    private Long propertyCompanyUserId; // 公司用户编号
    private String token; // 令牌
}
