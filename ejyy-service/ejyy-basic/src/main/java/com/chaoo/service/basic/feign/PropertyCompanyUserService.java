package com.chaoo.service.basic.feign;

import com.chaoo.service.basic.handler.PropertyCompanyUserServiceFallBack;
import com.chaoo.service.user.dto.UserListInfo;
import com.chaoo.service.user.dto.UserSelectWork;
import com.chaoo.service.user.entity.PropertyCompanyUser;
import org.checkerframework.checker.index.qual.PolySameLen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author chaoo
 * @Date: 2022/08/18/ 11:09
 */
@FeignClient( "user-server")
public interface PropertyCompanyUserService {


    /**
     * 返回需要查询的信息
     * @param id
     * @return
     */
    @GetMapping("/user/getOne/{id}")
    PropertyCompanyUser getOne(@PathVariable("id") Long id);

    /**
     * 远程调用获取员工真实姓名
     * @param pcUserInfoId
     * @return
     */
    @GetMapping("/user/getRealName/{pcUserInfoId}")
    String getRealName(@PathVariable("pcUserInfoId") Long pcUserInfoId);

    /**
     * 给员工派单维修
     * @param disposeUserId
     * @return
     */
    @GetMapping("/user/whoWork/{disposeUserId}")
    UserSelectWork whoWork(@PathVariable("disposeUserId") Long disposeUserId);

    /**
     * 远程调用查取员工列表
     * @return
     */
    @GetMapping("/user/list/{communityId}")
    List<UserListInfo> getEmploy(@PathVariable("communityId") Long communityId);
}
