package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
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

    @PostMapping("/detail")
    public Result detail(@RequestBody String json) {
        JSONObject jo = JSONObject.parseObject(json);
        Integer id = jo.getInteger("id");
        Long communityId = jo.getLong("community_id");
        LambdaQueryWrapper<Complain> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Complain::getId,id);
        queryWrapper.eq(Complain::getCommunity_id,communityId);
        Complain info = complainService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(info)) {
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(),"非法获取数据");
        }

        //
        PropertyCompanyUser allotInfo;
        if (info.getStep() >= 2) {
            LambdaQueryWrapper<PropertyCompanyUser> qw = new LambdaQueryWrapper<>();
            qw.select(PropertyCompanyUser::getId,PropertyCompanyUser::getRealName);
            qw.eq(PropertyCompanyUser::getId,info.getAllot_user_id());
            allotInfo = propertyCompanyUserService.getOne(qw);
        }


        return Result.ok();
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
        Map<String,Object> data = new HashMap<>();
        data.put("id",complain.getId());
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(),data);
    }
}
