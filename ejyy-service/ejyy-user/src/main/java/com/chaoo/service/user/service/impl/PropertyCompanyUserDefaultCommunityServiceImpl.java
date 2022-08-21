package com.chaoo.service.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.user.entity.PropertyCompanyUserDefaultCommunity;
import com.chaoo.service.user.mapper.PropertyCompanyUserDefaultCommunityMapper;
import com.chaoo.service.user.service.PropertyCompanyUserDefaultCommunityService;
import org.springframework.stereotype.Service;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 15:40
 *
 * 默认小区业务实现类
 */
@Service
public class PropertyCompanyUserDefaultCommunityServiceImpl extends ServiceImpl<PropertyCompanyUserDefaultCommunityMapper, PropertyCompanyUserDefaultCommunity> implements PropertyCompanyUserDefaultCommunityService {

    @Override
    public Long getCommunityId(Long userId) {
        QueryWrapper<PropertyCompanyUserDefaultCommunity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("community_id");
        queryWrapper.eq("property_company_user_id", userId);
        PropertyCompanyUserDefaultCommunity community =
                baseMapper.selectOne(queryWrapper);
        return ObjectUtils.isEmpty(community) ? 0 : community.getCommunity_id();
    }
}
