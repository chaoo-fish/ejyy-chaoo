package com.chaoo.service.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoo.service.user.dto.DepartJob;
import com.chaoo.service.user.dto.LoginInfo;
import com.chaoo.service.user.entity.PropertyCompanyUser;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 10:51
 *
 * 个人信息
 */

public interface PropertyCompanyUserService extends IService<PropertyCompanyUser> {
    /**
     * 登录 只需要一个账号 进行查询
     * @param account
     */
    LoginInfo login(String account);

    /**
     * 查询部门和职位
     * @param userId
     * @return
     */
    DepartJob info(Integer userId);
}
