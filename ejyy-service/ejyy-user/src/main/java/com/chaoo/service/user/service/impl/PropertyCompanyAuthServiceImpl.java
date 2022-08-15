package com.chaoo.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.user.entity.PropertyCompanyAuth;
import com.chaoo.service.user.mapper.PropertyCompanyAuthMapper;
import com.chaoo.service.user.service.PropertyCompanyAuthService;
import org.springframework.stereotype.Service;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 11:39
 *
 * 个人令牌和公司的中间表实体类
 * 个人 token 权限
 */
@Service
public class PropertyCompanyAuthServiceImpl extends ServiceImpl<PropertyCompanyAuthMapper, PropertyCompanyAuth> implements PropertyCompanyAuthService {
}
