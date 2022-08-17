package com.chaoo.service.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.basic.entity.Complain;
import com.chaoo.service.basic.mapper.ComplainMapper;
import com.chaoo.service.basic.service.ComplainService;
import org.springframework.stereotype.Service;

@Service
public class ComplainServiceImpl extends ServiceImpl<ComplainMapper, Complain> implements ComplainService {

}
