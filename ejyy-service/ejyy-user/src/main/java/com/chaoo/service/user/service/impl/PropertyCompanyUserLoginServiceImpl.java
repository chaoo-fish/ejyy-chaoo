package com.chaoo.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.user.entity.PropertyCompanyUserLogin;
import com.chaoo.service.user.mapper.PropertyCompanyUserLoginMapper;
import com.chaoo.service.user.service.PropertyCompanyUserLoginService;
import org.springframework.stereotype.Service;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 11:49
 *
 * 个人登录日志
 */
@Service
public class PropertyCompanyUserLoginServiceImpl extends ServiceImpl<PropertyCompanyUserLoginMapper, PropertyCompanyUserLogin> implements PropertyCompanyUserLoginService {
}
