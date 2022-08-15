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
public class PropertyCompanyUserAccessCommunity implements Serializable {
    private Long id;
    private Long propertyCompanyUserId; // 个人信息的编号
    private Long communityId; // 小区的编号
}