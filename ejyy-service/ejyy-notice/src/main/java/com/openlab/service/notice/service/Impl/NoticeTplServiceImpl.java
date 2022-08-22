package com.openlab.service.notice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openlab.service.notice.entity.NoticeTpl;
import com.openlab.service.notice.mapper.NoticeTplMapper;
import com.openlab.service.notice.service.NoticeTplService;
import org.springframework.stereotype.Service;

@Service
public class NoticeTplServiceImpl extends ServiceImpl<NoticeTplMapper, NoticeTpl> implements NoticeTplService {
}
