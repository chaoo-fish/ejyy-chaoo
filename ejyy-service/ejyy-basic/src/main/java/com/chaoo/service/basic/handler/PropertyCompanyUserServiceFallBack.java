package com.chaoo.service.basic.handler;

import com.chaoo.service.basic.feign.PropertyCompanyUserService;
import com.chaoo.service.user.dto.UserListInfo;
import com.chaoo.service.user.dto.UserSelectWork;
import com.chaoo.service.user.entity.PropertyCompanyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chaoo
 * @Date: 2022/08/18/ 11:12
 */
@Component
@Slf4j
public class PropertyCompanyUserServiceFallBack implements PropertyCompanyUserService {
    @Override
    public PropertyCompanyUser getOne(Long id) {
        log.warn("getOne 远程调用查找员工信息失败！！！");
        return new PropertyCompanyUser();
    }

    @Override
    public String getRealName(Long pcUserInfoId) {
        log.warn("getRealName 远程调用查找员工姓名失败！！！");
        return "测试人员";
    }

    @Override
    public List<UserListInfo> getEmploy(Long communityId) {
        log.warn("getEmploy 远程调用查找员工信息失败！！！");
        return new ArrayList<>();
    }

    @Override
    public UserSelectWork whoWork(Long disposeUserId) {
        log.warn("whoWork 员工派单失败！！！");
        return new UserSelectWork();
    }
}
