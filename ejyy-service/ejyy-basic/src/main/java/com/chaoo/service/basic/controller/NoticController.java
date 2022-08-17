package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.common.utils.TokenManager;
import com.chaoo.service.basic.dto.NoticInfo;
import com.chaoo.service.basic.entity.NoticeToUser;
import com.chaoo.service.basic.entity.NoticeTpl;
import com.chaoo.service.basic.service.NoticeToUserService;
import com.chaoo.service.basic.service.NoticeTplService;
import com.chaoo.service.user.service.PropertyCompanyUserService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 22:06
 * <p>
 * 小区通知
 */
@Slf4j
@CrossOrigin // 跨域
@RestController
@RequestMapping("/notice")
public class NoticController {

    @Autowired
    private NoticeTplService noticeTplService;

    @Autowired
    private NoticeToUserService noticeToUserService;


    @PostMapping("/detail")
    public Result detail(@RequestBody String json) {
        JSONObject jo = JSONObject.parseObject(json);
        String id = jo.getString("id");
        Long communityId = jo.getLong("community_id");

        return Result.ok();
    }
    /**
     * 创建消息 --- 阉割版
     */
    @PostMapping("/create")
    public Result create(@RequestBody NoticInfo noticInfo) {
//        System.out.println("json = " + json);
//        NoticInfo noticInfo = JSON.parseObject(json, NoticInfo.class);
        log.info("noticInfo :" + noticInfo);

//        // 存 NoticeTpl 消息模板  noticeTplService
        NoticeTpl nt = null;
        if (noticInfo.getOa_tpl_msg()) {
            nt = NoticeTpl.builder()
                    .tpl(noticInfo.getTpl())
                    .content(JSON.toJSONString(noticInfo.getContent()))
                    .build();
            noticeTplService.save(nt);
        }

        // 存消息
        NoticeToUser ntu = NoticeToUser.builder()
                .title(noticInfo.getTitle())
                .overview(noticInfo.getOverview())
                .community_id(noticInfo.getCommunity_id())
                .created_by(noticInfo.getUser_id())
                .content(noticInfo.getContent())
                .published(noticInfo.getPublished())
                .published_at(noticInfo.getPublished() == 1 ? new Date().getTime() : null)
                .published_by(noticInfo.getPublished() == 1 ? noticInfo.getUser_id() : null)
                .notice_tpl_id(ObjectUtils.isEmpty(nt) ? null : nt.getId())
                .created_at(new Date().getTime())
                .build();
        noticeToUserService.save(ntu);

        // 需要同步在公众号发布, 这里省略
        /*
            ...
         */

        Map<String, Object> data = new HashMap<>();
        data.put("id",ntu.getId());
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(),data);
    }


    /**
     * 微信公众号获取模板
     * 因本功能暂不做公众号，故返回假数据
     *
     * @return
     */
    @GetMapping("/tpl")
    public Result tpl() {
        Map<String, Object> data = new HashMap<>();
        data.put("list", "list");
        log.info("返回模板");
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }
}
