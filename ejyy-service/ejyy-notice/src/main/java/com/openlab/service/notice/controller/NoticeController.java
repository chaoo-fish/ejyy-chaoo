package com.openlab.service.notice.controller;


import com.chaoo.common.utils.Result;
import com.openlab.service.notice.dto.NoticetoUserDto;
import com.openlab.service.notice.dto.NoticetouserCommunityDto;
import com.openlab.service.notice.entity.NoticeToUser;
import com.openlab.service.notice.service.NoticeToUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeToUserService noticeToUserService;

    @PostMapping("/update")
    public Result Update(@RequestBody NoticetoUserDto noticetoUserDto){
        NoticeToUser noticeToUser=NoticeToUser.builder()
                .id(noticetoUserDto.getId())
                .title(noticetoUserDto.getTitle())
                .overview(noticetoUserDto.getOverview())
                .published(noticetoUserDto.getPublished())
                .content(noticetoUserDto.getContent().toString())
                .community_id(noticetoUserDto.getCommunity_id())
                .build();
        noticeToUserService.updateById(noticeToUser);
        return Result.ok(200,"更新成功");
    }

    @PostMapping("/list")
    public Result List(@RequestBody Map<String,Integer> user) {
        Integer integer = user.get("community_id");

        if(user.get("published")==null){
            List<NoticetouserCommunityDto> getpage = noticeToUserService.getpage((user.get("page_num")-1)*user.get("page_size"), user.get("page_size"));
            Map<String,Object> a=new HashMap<>();
            a.put("list",getpage);
            a.put("page_num",user.get("page_num"));
            a.put("page_size", user.get("page_size"));
            a.put("total",noticeToUserService.gettotal());
            return Result.ok(200,a);
        }
        List<NoticetouserCommunityDto> getpage = noticeToUserService.getpageL((user.get("page_num")-1)*user.get("page_size"), user.get("page_size"),user.get("published"));
        Map<String,Object> a=new HashMap<>();
        a.put("list",getpage);
        a.put("page_num",user.get("page_num"));
        a.put("page_size", user.get("page_size"));
        a.put("total",noticeToUserService.gettotalL(user.get("published")));
        return Result.ok(200,a);
    }

    @PostMapping("/create")
    public Result Create(@RequestBody NoticetoUserDto noticetoUserDto){
        System.out.println("noticetoUserDto = " + noticetoUserDto.toString());
        NoticeToUser noticeToUser=NoticeToUser.builder()
                .title(noticetoUserDto.getTitle())
                .overview(noticetoUserDto.getOverview())
                .published(noticetoUserDto.getPublished())
                .content(noticetoUserDto.getContent().toString())
                .created_by(noticetoUserDto.getCommunity_id())
                .created_at(noticetoUserDto.getCommunity_id())
                .published_by(noticetoUserDto.getCommunity_id())
                .community_id(noticetoUserDto.getCommunity_id())
                .notice_tpl_id(noticetoUserDto.getCommunity_id())
                .build();

        noticeToUserService.save(noticeToUser);
        Map<String, Object> data = new HashMap<>();
        data.put("id",noticeToUser.getId());

        return Result.ok(200,data);
    }

    @PostMapping("/detail")
    public Result Detail(@RequestBody Map<String,Integer> mes){
        Integer id = mes.get("id");
        NoticeToUser data = noticeToUserService.getById(id);
        Map<String,Object> re=new HashMap<>();

        re.put("detail",data);

        return Result.ok(200,re);

    }

    @PostMapping("/published")
    public Result Published(Long id){
        NoticeToUser build = NoticeToUser.builder()
                .id(id)
                .published(1)
                .build();
        noticeToUserService.updateById(build);
        return Result.ok();
    }

    @GetMapping("/tpl")
    public Result Tpl(){

        return Result.ok();
    }
}
