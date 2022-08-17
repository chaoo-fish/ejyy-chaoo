package com.chaoo.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoo.service.user.dto.CommunityDto;
import com.chaoo.service.user.dto.CommunityList;
import com.chaoo.service.user.entity.CommunityInfo;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 17:29
 *
 * 小区信息业务接口
 */
public interface CommunityInfoService extends IService<CommunityInfo> {
    CommunityDto getInfoByUserId(Long userId);
}
