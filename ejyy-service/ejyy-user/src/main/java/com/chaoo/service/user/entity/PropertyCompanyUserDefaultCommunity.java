package com.chaoo.service.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    private Long propertyCompanyUserId; // 公司编号
    private Long communityId; // 小区编号
}
