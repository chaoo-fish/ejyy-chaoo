package com.openlab.service.notice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openlab.service.notice.dto.NoticetouserCommunityDto;
import com.openlab.service.notice.entity.NoticeToUser;

import java.util.List;

public interface NoticeToUserService extends IService<NoticeToUser> {

    List<NoticetouserCommunityDto> getpage(int num, int size);
    List<NoticetouserCommunityDto> getpageL(int num, int size,  int published);
    Integer gettotal();
    Integer gettotalL(int published);
}
