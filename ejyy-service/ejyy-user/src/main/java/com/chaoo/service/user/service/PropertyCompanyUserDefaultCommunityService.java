package com.chaoo.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoo.service.user.entity.PropertyCompanyUserDefaultCommunity;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 15:40
 *
 * 默认小区业务层
 */
public interface PropertyCompanyUserDefaultCommunityService extends IService<PropertyCompanyUserDefaultCommunity> {
    Long getCommunityId(Long userId);
}
