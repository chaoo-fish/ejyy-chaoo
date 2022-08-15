package com.chaoo.service.init.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.init.entity.PropertyCompanyUserAccessCommunity;
import com.chaoo.service.init.mapper.PropertyCompanyUserAccessCommunityMapper;
import com.chaoo.service.init.service.PropertyCompanyUserAccessCommunityService;
import org.springframework.stereotype.Service;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 14:35
 *
 * 个人和小区中间表实现
 */
@Service
public class PropertyCompanyUserAccessCommunityServiceImpl extends ServiceImpl<PropertyCompanyUserAccessCommunityMapper, PropertyCompanyUserAccessCommunity> implements PropertyCompanyUserAccessCommunityService {
}
