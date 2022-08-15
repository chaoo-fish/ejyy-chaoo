package com.chaoo.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.user.entity.Repair;
import com.chaoo.service.user.mapper.RepairMapper;
import com.chaoo.service.user.service.RepairService;
import org.springframework.stereotype.Service;

@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {
}