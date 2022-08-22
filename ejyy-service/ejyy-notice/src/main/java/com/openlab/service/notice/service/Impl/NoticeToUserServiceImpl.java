package com.openlab.service.notice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openlab.service.notice.dto.NoticetouserCommunityDto;
import com.openlab.service.notice.entity.NoticeToUser;
import com.openlab.service.notice.mapper.NoticeToUserMapper;
import com.openlab.service.notice.service.NoticeToUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeToUserServiceImpl extends ServiceImpl<NoticeToUserMapper, NoticeToUser> implements NoticeToUserService {
    @Override
     public List<NoticetouserCommunityDto> getpage(int num, int size){

        return this.baseMapper.getpage(num,size);
    }

    @Override
    public List<NoticetouserCommunityDto> getpageL(int num, int size, int published) {
        return this.baseMapper.getpageL(num,size,published);
    }

    @Override
    public Integer gettotal() {
        return this.baseMapper.gettotal();
    }

    @Override
    public Integer gettotalL(int published) {
        return this.baseMapper.gettotalL(published);
    }

}
