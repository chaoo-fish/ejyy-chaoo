package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.service.basic.dto.ComplainDto;
import com.chaoo.service.basic.dto.ComplainInfo;
import com.chaoo.service.basic.entity.Complain;
import com.chaoo.service.basic.service.ComplainService;
import com.chaoo.service.user.entity.PropertyCompanyUser;
import com.chaoo.service.user.service.PropertyCompanyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
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


    @PostMapping("/merge_option")
    public Result mergeOption(@RequestBody String json) {
        JSONObject jo = JSONObject.parseObject(json);
        Integer id = jo.getInteger("id");
        Long communityId = jo.getLong("community_id");

        LambdaQueryWrapper<Complain> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.isNull(Complain::getMerge_id);
        queryWrapper.eq(Complain::getId, id);
        queryWrapper.eq(Complain::getCommunity_id, communityId);
        queryWrapper.eq(Complain::getStep,1);

        Complain detail = complainService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(detail)) {
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(), "非法维修工单");
        }

        Map<String, Object> data = new HashMap<>();

        return Result.ok(ResultCodeEnum.SUCCESS.getCode(),data);
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
        PropertyCompanyUser referInfo = null;
        if (info.getStep() >= 2) {
            LambdaQueryWrapper<PropertyCompanyUser> qw = new LambdaQueryWrapper<>();
            qw.select(PropertyCompanyUser::getId, PropertyCompanyUser::getReal_name);
            qw.eq(PropertyCompanyUser::getId, info.getAllot_user_id());
            allotInfo = propertyCompanyUserService.getOne(qw);
            log.info("查询 allotInfo 完毕");

            LambdaQueryWrapper<PropertyCompanyUser> qw1 = new LambdaQueryWrapper<>();
            qw1.select(PropertyCompanyUser::getId, PropertyCompanyUser::getReal_name);
            qw1.eq(PropertyCompanyUser::getId, info.getDispose_user_id());
            disposedInfo = propertyCompanyUserService.getOne(qw1);
            log.info("查询 disposedInfo 完毕");
        }

        if (info.getProperty_company_user_id() != null) {
            LambdaQueryWrapper<PropertyCompanyUser> qw = new LambdaQueryWrapper<>();
            qw.select(PropertyCompanyUser::getId, PropertyCompanyUser::getReal_name);
            qw.eq(PropertyCompanyUser::getId, info.getProperty_company_user_id());
            referInfo = propertyCompanyUserService.getOne(qw);
            log.info("查询 referInfo  getProperty_company_user_id完毕");
        } else {
            LambdaQueryWrapper<PropertyCompanyUser> qw = new LambdaQueryWrapper<>();
            qw.select(PropertyCompanyUser::getId, PropertyCompanyUser::getReal_name);
            qw.eq(PropertyCompanyUser::getId, info.getWechat_mp_user_id());
            referInfo = propertyCompanyUserService.getOne(qw);
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
