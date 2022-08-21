package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.service.basic.dto.ComplainDto;
import com.chaoo.service.basic.dto.ComplainInfo;
import com.chaoo.service.basic.dto.ComplainSearch;
import com.chaoo.service.basic.entity.Complain;
import com.chaoo.service.basic.entity.WechatMpUser;
import com.chaoo.service.basic.feign.PropertyCompanyUserService;
import com.chaoo.service.basic.service.ComplainService;
import com.chaoo.service.basic.service.WechatMpUserService;
import com.chaoo.service.user.dto.UserSelectWork;
import com.chaoo.service.user.entity.PropertyCompanyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chaoo
 * @Date: 2022/08/17/ 13:32
 * <p>
 * 投诉模块
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @Autowired
    private PropertyCompanyUserService propertyCompanyUserService;

    @Autowired
    private WechatMpUserService wechatMpUserService;


    @PostMapping("/list")
    public Result list(@RequestBody ComplainSearch cs) {
        Page<Complain> pageInfo = new Page<>(cs.getPage_num(), cs.getPage_size());

        LambdaQueryWrapper<Complain> clqw = new LambdaQueryWrapper<>();
        clqw.eq(Complain::getCommunity_id,cs.getCommunity_id())
                .eq(cs.getStep() != null, Complain::getStep, cs.getStep())
                .eq(cs.getType() != null, Complain::getType, cs.getType())
                .eq(cs.getCategory() != null, Complain::getCategory, cs.getCategory())
                .orderByDesc(Complain::getId);
        if (cs.getRefer() != null) {
            if (cs.getRefer().equals("ower")) {
                clqw.isNotNull(Complain::getWechat_mp_user_id);
            } else {
                clqw.isNotNull(Complain::getProperty_company_user_id);
            }
        }
        complainService.page(pageInfo,clqw);

        Map<String, Object> data = new HashMap<>();
        data.put("page_num", pageInfo.getCurrent());
        data.put("page_size", pageInfo.getSize());
        data.put("total", pageInfo.getTotal());
        data.put("list", pageInfo.getRecords());
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }

    /**
     * 派单
     *
     * @param json
     * @return
     */
    @PostMapping("/allot")
    public Result allot(@RequestBody String json) {
        JSONObject jo = JSONObject.parseObject(json);
        Long communityId = jo.getLong("community_id");
        Long id = jo.getLong("id");
        Long disposeUserId = jo.getLong("dispose_user_id");
        Long pcUserInfoId = jo.getLong("pcUserInfo_id");
        LambdaQueryWrapper<Complain> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Complain::getId, id);
        queryWrapper.eq(Complain::getCommunity_id, communityId);
        queryWrapper.eq(Complain::getStep, 1);
        Complain detail = complainService.getOne(queryWrapper);
        if (detail == null) {
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(), "非法维修工单");
        }

        // disposedInfo
        UserSelectWork disposedInfo = propertyCompanyUserService.whoWork(disposeUserId);
        if (disposedInfo == null) {
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(), "非法维修工单");
        }
        /**
         * 省略小程序和微信推送
         */

        // 更新
        LambdaUpdateWrapper<Complain> cqw = new LambdaUpdateWrapper<>();
        cqw.set(Complain::getStep, 2);
        cqw.set(Complain::getAllot_user_id, pcUserInfoId);
        cqw.set(Complain::getAlloted_at, new Date().getTime());
        cqw.set(Complain::getDispose_user_id, disposeUserId);
        cqw.eq(Complain::getId, id);
        complainService.update(cqw);

        disposedInfo.setOpen_id(null);
        disposedInfo.setSubscribed(null);

        // 获取真实姓名
        String realName = propertyCompanyUserService.getRealName(pcUserInfoId);

        Map<String, Object> data = new HashMap<>();
        Map<String, Object> allotInfo = new HashMap<>();
        allotInfo.put("id", pcUserInfoId);
        allotInfo.put("real_name", realName);
        data.put("alloted_at", new Date().getTime());
        data.put("allotInfo", allotInfo);
        data.put("disposedInfo", disposedInfo);
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }

    @PostMapping("/merge_option")
    public Result mergeOption(@RequestBody String json) {
        JSONObject jo = JSONObject.parseObject(json);
        Integer id = jo.getInteger("id");
        Long communityId = jo.getLong("community_id");

        LambdaQueryWrapper<Complain> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.isNull(Complain::getMerge_id);
        queryWrapper.eq(Complain::getId, id);
        queryWrapper.eq(Complain::getCommunity_id, communityId);
        queryWrapper.eq(Complain::getStep, 1);

        Complain detail = complainService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(detail)) {
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(), "非法维修工单");
        }

        LambdaQueryWrapper<Complain> qw = new LambdaQueryWrapper<>();
        qw.select(Complain::getId, Complain::getDescription, Complain::getType, Complain::getCategory, Complain::getStep, Complain::getCreated_at);
        qw.isNull(Complain::getMerge_id);
        qw.eq(Complain::getCommunity_id, communityId);
        qw.eq(Complain::getId, id);
        qw.le(Complain::getCreated_at, detail.getCreated_at() + 1000 * 60 * 60 * 24);
        qw.ge(Complain::getCreated_at, detail.getCreated_at() - 1000 * 60 * 60 * 24);
        qw.eq(Complain::getStep, 1);
        List<Complain> list = complainService.list(qw);

        Map<String, Object> data = new HashMap<>();
        data.put("list", list);
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody String json) {
        JSONObject jo = JSONObject.parseObject(json);
        Integer id = jo.getInteger("id");
        Long communityId = jo.getLong("community_id");
        LambdaQueryWrapper<Complain> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Complain::getId, id);
        queryWrapper.eq(Complain::getCommunity_id, communityId);
        Complain info = complainService.getOne(queryWrapper);
        log.info("查询 info 完毕");
        if (ObjectUtils.isEmpty(info)) {
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(), "非法获取数据");
        }

        //
        PropertyCompanyUser allotInfo = null;
        PropertyCompanyUser disposedInfo = null;
        Object referInfo = null;
        if (info.getStep() >= 2) {
            log.info("查询 allotInfo 开始");
            allotInfo = propertyCompanyUserService.getOne(info.getAllot_user_id());
            log.info("查询 allotInfo 完毕");

            log.info("查询 disposedInfo 开始");
            disposedInfo = propertyCompanyUserService.getOne(info.getDispose_user_id());
            log.info("查询 disposedInfo 完毕");
        }

        if (info.getProperty_company_user_id() != null) {
            referInfo = propertyCompanyUserService.getOne(info.getProperty_company_user_id());
            log.info("查询 referInfo  getProperty_company_user_id完毕");
        } else {
            LambdaQueryWrapper<WechatMpUser> qw = new LambdaQueryWrapper<>();
            qw.select(WechatMpUser::getId, WechatMpUser::getReal_name);
            qw.eq(WechatMpUser::getId, info.getWechat_mp_user_id());
            referInfo = wechatMpUserService.getOne(qw);
            log.info("查询 referInfo getWechat_mp_user_id完毕");
        }

        String refer = info.getProperty_company_user_id() != null ? "colleague" : "ower";

        info.setAllot_user_id(null);
        info.setDispose_user_id(null);
        info.setProperty_company_user_id(null);
        info.setWechat_mp_user_id(null);

        ComplainDto infoDto = JSONObject.parseObject(JSONObject.toJSONString(info), ComplainDto.class);
        infoDto.setRefer(refer);

        /**
         * 省略照片信息
         */

        Map<String, Object> data = new HashMap<>();
        data.put("info", infoDto);
        data.put("referInfo", referInfo);
        data.put("allotInfo", allotInfo);
        data.put("disposedInfo", disposedInfo);

        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }

    @PostMapping("/create")
    public Result create(@RequestBody ComplainInfo complainInfo) {
        log.info("complainInfo: " + complainInfo);
        Complain complain = Complain.builder()
                .property_company_user_id(complainInfo.getWechat_mp_user_id() != null ? null : complainInfo.getProperty_company_user_id())
                .wechat_mp_user_id(complainInfo.getWechat_mp_user_id() != null ? complainInfo.getWechat_mp_user_id() : null)
                .community_id(complainInfo.getCommunity_id())
                .type(complainInfo.getType())
                .category(complainInfo.getCategory())
                .description(complainInfo.getDescription())
                .complain_imgs(complainInfo.getComplain_imgs() != null ? String.join("#", complainInfo.getComplain_imgs()) : null)
                .step(1) // 1 是已经提交
                .created_at(new Date().getTime())
                .build();
        complainService.save(complain);
        Map<String, Object> data = new HashMap<>();
        data.put("id", complain.getId());
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }
}
