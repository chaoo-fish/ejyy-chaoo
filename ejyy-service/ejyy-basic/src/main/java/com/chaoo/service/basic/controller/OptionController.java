package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.service.basic.dto.PhoneDto;
import com.chaoo.service.basic.dto.userBuildInfoDto;
import com.chaoo.service.basic.entity.WechatMpUser;
import com.chaoo.service.basic.service.UserBuildingService;
import com.chaoo.service.basic.service.WechatMpUserService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 19:51
 */
@Slf4j
@CrossOrigin // 跨域
@RestController
@RequestMapping("/option")
public class OptionController {

    @Autowired
    private WechatMpUserService wechatMpUserService;
    @Autowired
    private UserBuildingService userBuildingService;

    /**
     * 检查业主是否存在
     * @return
     */
    @PostMapping("/ower")
    public Result checkPhone(@RequestBody String json){
        // 接受前端数据
        PhoneDto phoneDto = JSON.parseObject(json, PhoneDto.class);

        // 通过电话查询业主
        QueryWrapper<WechatMpUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phoneDto.getPhone());
        queryWrapper.eq("intact",true);

        WechatMpUser owerInfo = wechatMpUserService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(owerInfo)){ // 未查询到业主信息
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(),"未查询到业主信息");
        }
        // 通过业主查住宅
        List<userBuildInfoDto> userBuildInfoDtos = userBuildingService.selectBuild(owerInfo.getId(), Long.valueOf(phoneDto.getCommunity_id()));

        if (userBuildInfoDtos.size() == 0) {
            return Result.ok(ResultCodeEnum.QUERY_ILLEFAL.getCode(),"未查询到业主信息");
        }

        return Result.ok();
    }
}
