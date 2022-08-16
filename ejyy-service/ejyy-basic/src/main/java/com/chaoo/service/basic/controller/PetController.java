package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.service.basic.dto.PetInfo;
import com.chaoo.service.basic.entity.Pet;
import com.chaoo.service.basic.entity.PetVaccinate;
import com.chaoo.service.basic.service.PetService;
import com.chaoo.service.basic.service.PetVaccinateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private PetVaccinateService petVaccinateService;

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
                .photo("我没有照片")
                .breed(petInfo.getBreed())
                .createdAt(new Date().getTime())
                .petLicense(petInfo.getPet_license())
                .petLicenseAwardAt(new Date().getTime())
                .build();
        log.info("获取宠物信息: " + pet);
        petService.save(pet);
        // 宠物有证
        Map<String,Object> data = new HashMap<>();
        if (petInfo.isHaveLicense()) {
            // 更新疫苗
            PetVaccinate pv = PetVaccinate.builder()
                    .petId(pet.getId())
                    .vaccinatedAt(petInfo.getVaccinated_at())
                    .vaccineType(petInfo.getVaccine_type())
                    .createdAt(new Date().getTime())
                    .build();
            log.info("获取疫苗信息: " + pv);
            petVaccinateService.save(pv);
            data.put("id",pv.getId());
        }

        return Result.ok(ResultCodeEnum.SUCCESS.getCode(),data);
    }
}
