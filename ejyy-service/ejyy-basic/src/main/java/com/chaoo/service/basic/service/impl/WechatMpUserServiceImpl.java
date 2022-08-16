package com.chaoo.service.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.basic.entity.WechatMpUser;
import com.chaoo.service.basic.mapper.WechatMpUserMapper;
import com.chaoo.service.basic.service.WechatMpUserService;
import org.springframework.stereotype.Service;

@Service
public class WechatMpUserServiceImpl extends ServiceImpl<WechatMpUserMapper, WechatMpUser> implements WechatMpUserService {

}