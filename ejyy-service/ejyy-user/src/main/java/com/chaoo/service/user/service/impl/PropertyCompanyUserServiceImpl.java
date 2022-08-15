package com.chaoo.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.user.dto.DepartJob;
import com.chaoo.service.user.dto.LoginInfo;
import com.chaoo.service.user.entity.PropertyCompanyUser;
import com.chaoo.service.user.mapper.PropertyCompanyUserMapper;
import com.chaoo.service.user.service.PropertyCompanyUserService;
import org.springframework.stereotype.Service;

@Service
public class PropertyCompanyUserServiceImpl extends ServiceImpl<PropertyCompanyUserMapper, PropertyCompanyUser> implements PropertyCompanyUserService {
    /**
     * 实现登录功能
     * @param account 用户账号
     * @return 登录信息
     */
    @Override
    public LoginInfo login(String account) {
        return baseMapper.login(account);
    }

    /**
     * 实现部门
     * @param userId
     * @return
     */
    @Override
    public DepartJob info(Integer userId) {
        return baseMapper.getInfoByUserId(userId);
    }
}
