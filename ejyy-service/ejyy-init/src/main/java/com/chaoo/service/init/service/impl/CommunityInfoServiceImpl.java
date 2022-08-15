package com.chaoo.service.init.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.init.entity.CommunityInfo;
import com.chaoo.service.init.mapper.CommunityInfoMapper;
import com.chaoo.service.init.service.CommunityInfoService;
import org.springframework.stereotype.Service;

/**
 * 小区业务层实现类
 */
@Service
public class CommunityInfoServiceImpl extends ServiceImpl<CommunityInfoMapper, CommunityInfo> implements CommunityInfoService {

}