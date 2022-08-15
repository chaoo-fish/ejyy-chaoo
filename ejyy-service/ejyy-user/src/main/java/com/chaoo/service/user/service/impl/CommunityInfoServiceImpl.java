package com.chaoo.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.user.dto.CommunityDto;
import com.chaoo.service.user.entity.CommunityInfo;
import com.chaoo.service.user.mapper.CommunityInfoMapper;
import com.chaoo.service.user.service.CommunityInfoService;
import org.springframework.stereotype.Service;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 17:29
 */
@Service
public class CommunityInfoServiceImpl extends ServiceImpl<CommunityInfoMapper, CommunityInfo> implements CommunityInfoService {
    @Override
    public CommunityDto getInfoByUserId(Long userId) {
        return baseMapper.communityInfo(userId);
    }
}
