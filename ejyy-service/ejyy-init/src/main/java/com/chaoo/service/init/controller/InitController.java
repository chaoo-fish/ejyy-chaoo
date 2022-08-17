package com.chaoo.service.init.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoo.common.utils.IDCardUtil;
import com.chaoo.common.utils.MD5;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.service.init.dto.ParamDto;
import com.chaoo.service.init.entity.*;
import com.chaoo.service.init.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 10:24
 */
@Controller
@RequestMapping("/init")
@CrossOrigin // 支持跨域
public class InitController {
    @Autowired
    private CommunitySettingService communitySettingService;
    @Autowired
    private CommunityInfoService communityInfoService;
    @Autowired
    private PropertyCompanyAuthService propertyCompanyAuthService;
    @Autowired
    private PropertyCompanyUserService propertyCompanyUserService;
    @Autowired
    private PropertyCompanyUserAccessCommunityService propertyCompanyUserAccessCommunityService;

    @ResponseBody
    @PostMapping("/run")
    public Result run(@RequestBody ParamDto paramDto) {
        // 验证 用户 账号唯一
        QueryWrapper<PropertyCompanyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",paramDto.getAccount());
        PropertyCompanyUser user = propertyCompanyUserService.getOne(queryWrapper);
        if (!ObjectUtils.isEmpty(user)) {
            return Result.ok(ResultCodeEnum.ACCOUNT_EXIST.getCode(), "账号存在");
        }

        // 保存个人信息
        PropertyCompanyUser propertyCompanyUser = PropertyCompanyUser.builder()
                .account(paramDto.getAccount())
                .password(MD5.encrypt(paramDto.getPassword())) // 已完成TODO  密码需要MD5加密,此功能还未完成
                .idcard(paramDto.getIdcard())
                .realName(paramDto.getReal_name())
                .gender(IDCardUtil.getSex(paramDto.getIdcard()))
                .phone(paramDto.getPhone())
                .admin(true)
                .leaveOffice(false)
                .joinCompanyAt(new Date().getTime())
                .createdAt(new Date().getTime())
                .build();
        propertyCompanyUserService.save(propertyCompanyUser);


        // 如果小区已存在
        CommunityInfo one = communityInfoService.getOne(new LambdaQueryWrapper<CommunityInfo>().eq(CommunityInfo::getName, paramDto.getName()));
        // 不存在才会去保存小区信息和设置
        if (one == null) {
            // 保存小区信息
            CommunityInfo communityInfo = CommunityInfo.builder()
                    .name(paramDto.getName())
                    .banner(paramDto.getBanner())
                    .province(paramDto.getProvince())
                    .city(paramDto.getCity())
                    .district(paramDto.getDistrict())
                    .phone(paramDto.getPhone())
                    .createdAt(new Date().getTime())
                    .createdBy(propertyCompanyUser.getId().longValue())
                    .build();
            communityInfoService.save(communityInfo);

            // 小区设置表
            CommunitySetting communitySetting = CommunitySetting.builder()
                    .accessNfc(paramDto.isAccess_nfc())
                    .accessRemote(paramDto.isAccess_remote())
                    .accessQrcode(paramDto.isAccess_qrcode())
                    .fitmentPledge(paramDto.isFitment_pledge())
                    .carportMaxCar(paramDto.getCarport_max_car())
                    .communityId(communityInfo.getId())
                    .build();
            communitySettingService.save(communitySetting);
        }

        // 个人和小区的中间表
        PropertyCompanyUserAccessCommunity accessCommunity = PropertyCompanyUserAccessCommunity.builder()
                .communityId(one.getId())
                .propertyCompanyUserId(propertyCompanyUser.getId().longValue())
                .build();
        propertyCompanyUserAccessCommunityService.save(accessCommunity);

        // 个人令牌和公司的中间表实体类
        PropertyCompanyAuth propertyCompanyAuth = PropertyCompanyAuth.builder()
                .propertyCompanyUserId(propertyCompanyUser.getId().longValue())
                .token(null)
                .build();
        propertyCompanyAuthService.save(propertyCompanyAuth);


        return Result.ok();
    }
}
