package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.chaoo.common.utils.Result;
import com.chaoo.service.basic.dto.PetInfo;
import com.chaoo.service.basic.entity.Pet;
import com.chaoo.service.basic.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 21:17
 */
@Slf4j
@CrossOrigin // 跨域
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/create")
    public Result create(@RequestBody String json){
        PetInfo petInfo = JSON.parseObject(json, PetInfo.class);
        Pet pet = Pet.builder()
                .wechatMpUserId(petInfo.getUser_id())
                .communityId(petInfo.getCommunity_id())
                .petType(petInfo.getPet_type())
                .name(petInfo.getName())
                .sex(petInfo.getSex())
                .coatColor(petInfo.getCoat_color())
                .breed(petInfo.getBreed())
                .createdAt(new Date().getTime())
                .petLicense(petInfo.getPet_license())
                .petLicenseAwardAt(new Date().getTime())
                .build();
        log.info("获取宠物信息: " + pet);
        // 宠物有证
        if (petInfo.isHaveLicense()) {
            // 更新疫苗

        }
//        petService.save(pet);
        System.out.println("pet = " + pet);
        return Result.ok(300,"yes");
    }
}
