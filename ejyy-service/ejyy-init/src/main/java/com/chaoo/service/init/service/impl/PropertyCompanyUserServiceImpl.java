package com.chaoo.service.init.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.init.entity.PropertyCompanyUser;
import com.chaoo.service.init.mapper.PropertyCompanyUserMapper;
import com.chaoo.service.init.service.PropertyCompanyUserService;
import org.springframework.stereotype.Service;

/**
 * 个人信息业务层实现类
 */
@Service
public class PropertyCompanyUserServiceImpl extends ServiceImpl<PropertyCompanyUserMapper, PropertyCompanyUser> implements PropertyCompanyUserService {

}