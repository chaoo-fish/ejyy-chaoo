package com.chaoo.service.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.basic.dto.userBuildInfoDto;
import com.chaoo.service.basic.entity.UserBuilding;
import com.chaoo.service.basic.mapper.UserBuildingMapper;
import com.chaoo.service.basic.service.UserBuildingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBuildingServiceImpl extends ServiceImpl<UserBuildingMapper, UserBuilding> implements UserBuildingService {

    public List<userBuildInfoDto> selectBuild(Long wuserId, Long bcommunityId) {
        return baseMapper.selectBuild(wuserId, bcommunityId);
    }
}