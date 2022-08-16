package com.chaoo.service.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoo.service.basic.dto.userBuildInfoDto;
import com.chaoo.service.basic.entity.UserBuilding;

import java.util.List;

public interface UserBuildingService extends IService<UserBuilding> {
    List<userBuildInfoDto> selectBuild(Long wuserId,Long bcommunityId);
}