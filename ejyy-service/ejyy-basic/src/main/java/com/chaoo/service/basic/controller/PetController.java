package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.service.basic.dto.*;
import com.chaoo.service.basic.entity.Pet;
import com.chaoo.service.basic.entity.PetJson;
import com.chaoo.service.basic.entity.PetVaccinate;
import com.chaoo.service.basic.service.PetService;
import com.chaoo.service.basic.service.PetVaccinateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    /**
     * 添加宠物疫苗
     * @param jsonVaccinate json数据
     * @return result
     */
    @PostMapping("/vaccinate/{id}")
    public Result vaccinate(@PathVariable("id") Long id, @RequestBody String jsonVaccinate){
        JSONObject jo = JSONObject.parseObject(jsonVaccinate);
        System.out.println(jo.getString("vaccine_type"));
        System.out.println("id = " + id);
        return Result.ok();
    }

    // 宠物详细信息
    @PostMapping("/detail")
    public Result detail(@RequestBody String jsonPet) {
        JSONObject jo = JSONObject.parseObject(jsonPet);
        String id = jo.getString("id");
        Integer communityId = jo.getInteger("community_id");
        // 宠物详细信息
        PetDetail preinfo = petService.deatil(id, communityId);
        // 格式化信息返回前端
        PetDetailJson info = PetDetailJson.builder()
                .id(preinfo.getId())
                .wechat_mp_user_id(preinfo.getWechatMpUserId())
                .name(preinfo.getRealName())
                .sex(preinfo.getSex())
                .pet_type(preinfo.getPetType())
                .coat_color(preinfo.getCoatColor())
                .breed(preinfo.getBreed())
                .photo(preinfo.getPhoto())
                .pet_license(preinfo.getPetLicense())
                .pet_license_award_at(preinfo.getPetLicenseAwardAt())
                .community_name(preinfo.getCommunityName())
                .remove(preinfo.getRemove())
                .remove_reason(preinfo.getRemoveReason())
                .removed_at(preinfo.getRemovedAt())
                .real_name(preinfo.getRealName())
                .build();
        // 宠物疫苗
        LambdaQueryWrapper<PetVaccinate> pvQuery = new LambdaQueryWrapper<>();
        pvQuery.eq(PetVaccinate::getId, preinfo.getId());
        List<PetVaccinate> preVaccinates = petVaccinateService.list(pvQuery);
        List<PetVaccinateLessInfo> vaccinates = new ArrayList<>();
        for (PetVaccinate pv : preVaccinates) {
            vaccinates.add(PetVaccinateLessInfo.builder()
                    .vaccinated_at(pv.getVaccinatedAt())
                    .vaccine_type(pv.getVaccineType())
                    .build());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("info", info);
        data.put("vaccinates", vaccinates);
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }

    // 宠物列表
    @PostMapping("/list")
    public Result list(@RequestBody String jsonPet) {
        PetSearch ps = JSON.parseObject(jsonPet, PetSearch.class);
        log.info("宠物列表的查询条件: " + ps);

        // 构造分页构造器
        Page pageInfo = new Page(ps.getPage_num(), ps.getPage_size());

        // 构造条件构造器
        LambdaQueryWrapper<Pet> queryWrapper = new LambdaQueryWrapper<>();
        // 添加条件
        queryWrapper.like(ps.getSex() != null, Pet::getSex, ps.getSex());
        queryWrapper.like(ps.getLicense() != null, Pet::getPetLicense, ps.getLicense());
        queryWrapper.like(ps.getBreed() != null, Pet::getBreed, ps.getBreed());
//        queryWrapper.like(ps.getCoat_color() !=  null,Pet::getCoat_color,ps.getCoat_color());
        queryWrapper.like(ps.getRemove() != null, Pet::getRemove, ps.getRemove());
        // 添加社区条件
        queryWrapper.eq(Pet::getCommunityId, ps.getCommunity_id());
        queryWrapper.orderByDesc(Pet::getId);

        // 执行查询
        petService.page(pageInfo, queryWrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("page_num", pageInfo.getPages());
        data.put("page_size", pageInfo.getSize());
        data.put("total", pageInfo.getTotal());
        List records = pageInfo.getRecords();
        List<PetJson> rec = new ArrayList();
        for (Object o : records) {
            Pet p = (Pet) o;
            PetJson pj = PetJson.builder()
                    .id(p.getId())
                    .wechatMpUserId(p.getWechatMpUserId())
                    .communityId(p.getCommunityId())
                    .pet_type(p.getPetType())
                    .name(p.getName())
                    .sex(p.getSex())
                    .pet_license(p.getPhoto())
                    .coat_color(p.getCoatColor())
                    .breed(p.getBreed())
                    .pet_license(p.getPetLicense())
                    .pet_license_award_at(p.getPetLicenseAwardAt())
                    .remove(p.getRemove())
                    .remove_reason(p.getRemoveReason())
                    .removed_at(p.getRemovedAt())
                    .created_at(p.getCreatedAt())
                    .build();
            rec.add(pj);
        }
        data.put("list", rec);


        return Result.ok(200, data);
    }

    // 宠物创建
    @PostMapping("/create")
    public Result create(@RequestBody String json) {
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
                .petLicense(petInfo.getPet_license())
                .petLicenseAwardAt(new Date().getTime())
                .createdAt(new Date().getTime())
                .build();
        log.info("获取宠物信息: " + pet);
        petService.save(pet);
        // 宠物有证
        Map<String, Object> data = new HashMap<>();
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
            data.put("id", pv.getId());
        }

        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }
}
