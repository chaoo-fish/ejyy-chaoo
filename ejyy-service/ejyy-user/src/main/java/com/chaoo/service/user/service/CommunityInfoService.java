package com.chaoo.service.user.service;

import com.chaoo.service.user.dto.CommunityDto;
import com.chaoo.service.user.dto.CommunityList;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 17:29
 *
 * 小区信息业务接口
 */
public interface CommunityInfoService {
    CommunityDto getInfoByUserId(Long userId);
}
