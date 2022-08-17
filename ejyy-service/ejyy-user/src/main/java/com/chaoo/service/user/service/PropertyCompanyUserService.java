package com.chaoo.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoo.service.user.dto.DepartJob;
import com.chaoo.service.user.dto.LoginInfo;
import com.chaoo.service.user.dto.UserListInfo;
import com.chaoo.service.user.dto.UserSelectWork;
import com.chaoo.service.user.entity.PropertyCompanyUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 员工
     * @param community_id
     * @return
     */
    List<UserListInfo> getEmploy(Long community_id);


    UserSelectWork whoWork( Long id);
}
