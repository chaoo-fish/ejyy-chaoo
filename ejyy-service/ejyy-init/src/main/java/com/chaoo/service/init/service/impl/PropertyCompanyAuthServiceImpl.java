package com.chaoo.service.init.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.init.entity.PropertyCompanyAuth;
import com.chaoo.service.init.mapper.PropertyCompanyAuthMapper;
import com.chaoo.service.init.service.PropertyCompanyAuthService;
import org.springframework.stereotype.Service;

/**
 * 个人令牌和公司的中间表业务层实现类
 */
@Service
public class PropertyCompanyAuthServiceImpl extends ServiceImpl<PropertyCompanyAuthMapper, PropertyCompanyAuth> implements PropertyCompanyAuthService {

}

