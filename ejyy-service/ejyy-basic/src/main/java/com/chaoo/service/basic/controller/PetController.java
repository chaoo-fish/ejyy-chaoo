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
 *
 * 宠物
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
     * 更新宠物编号
     */
    @PostMapping("/license/{id}")
    public Result license(@PathVariable("id") Long id, @RequestBody String jsonPet) {
        JSONObject jo = JSONObject.parseObject(jsonPet);
        String petLicense = jo.getString("pet_license");
        Long awardAt = jo.getLong("pet_license_award_at");
        Long communityId = jo.getLong("community_id");
        LambdaQueryWrapper<Pet> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Pet::getId, id);
        queryWrapper.eq(Pet::getCommunity_id, communityId);
        // 先获取
        Pet pet = petService.getOne(queryWrapper);
        pet.setPet_license(petLicense);
        pet.setPet_license_award_at(awardAt);;
        boolean flag = petService.updateById(pet);
        if (!flag) {
            return Result.ok(ResultCodeEnum.DATA_MODEL_UPDATE_FAIL.getCode(),"更新宠物登记证件失败");
        }
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(),"更新宠物登记证件成功");
    }

    /**
     * 添加宠物疫苗
     *
     * @param jsonVaccinate
     *         json数据
     * @return result
     */
    @PostMapping("/vaccinate/{id}")
    public Result vaccinate(@PathVariable("id") Long id, @RequestBody String jsonVaccinate) {
        JSONObject jo = JSONObject.parseObject(jsonVaccinate);
        String vtype = jo.getString("vaccine_type");
        Long vat = jo.getLong("vaccinated_at");
        PetVaccinate pv = PetVaccinate.builder()
                .pet_id(id)
                .vaccine_type(vtype)
                .vaccinated_at(vat)
                .created_at(new Date().getTime())
                .build();
        petVaccinateService.save(pv);
        Map<String, Object> data = new HashMap<>();
        data.put("id", pv);
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }


    /**
     * 宠物详细信息
     * @param jsonPet
     * @return
     */
    @PostMapping("/detail")
    public Result detail(@RequestBody String jsonPet) {
        JSONObject jo = JSONObject.parseObject(jsonPet);
        String id = jo.getString("id");
        Integer communityId = jo.getInteger("community_id");
        // 宠物详细信息
        PetDetail info = petService.deatil(id, communityId);
        // 宠物疫苗
        LambdaQueryWrapper<PetVaccinate> pvQuery = new LambdaQueryWrapper<>();
        pvQuery.eq(PetVaccinate::getPet_id, info.getId());
        List<PetVaccinate> preVaccinates = petVaccinateService.list(pvQuery);
        List<PetVaccinateLessInfo> vaccinates = new ArrayList<>();
        for (PetVaccinate pv : preVaccinates) {
            vaccinates.add(PetVaccinateLessInfo.builder()
                    .vaccinated_at(pv.getVaccinated_at())
                    .vaccine_type(pv.getVaccine_type())
                    .build());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("info", info);
        data.put("vaccinates", vaccinates);
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }

    /**
     * 宠物列表
     * @param jsonPet
     * @return
     */
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
        // 未登记
        queryWrapper.eq(ps.getLicense() != null && !ps.getLicense(), Pet::getPet_license, "");
        // 以登记
        queryWrapper.ne(ps.getLicense() != null && ps.getLicense(), Pet::getPet_license, "");
        queryWrapper.like(ps.getBreed() != null, Pet::getBreed, ps.getBreed());
        queryWrapper.like(ps.getRemove() != null, Pet::getRemove, ps.getRemove());
        // 添加社区条件
        queryWrapper.eq(Pet::getCommunity_id, ps.getCommunity_id());
        queryWrapper.orderByDesc(Pet::getId);

        // 执行查询
        petService.page(pageInfo, queryWrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("page_num", pageInfo.getCurrent());
        data.put("page_size", pageInfo.getSize());
        data.put("total", pageInfo.getTotal());
        data.put("list", pageInfo.getRecords());


        return Result.ok(200, data);
    }

    /**
     * 宠物创建
     * @param json
     * @return
     */
    @PostMapping("/create")
    public Result create(@RequestBody String json) {
        PetInfo petInfo = JSON.parseObject(json, PetInfo.class);
        Pet pet = Pet.builder()
                .wechat_mp_user_id(petInfo.getUser_id())
                .community_id(petInfo.getCommunity_id())
                .pet_type(petInfo.getPet_type())
                .name(petInfo.getName())
                .sex(petInfo.getSex())
                .coat_color(petInfo.getCoat_color())
                .photo("我没有照片")
                .breed(petInfo.getBreed())
                .pet_license(petInfo.getPet_license())
                .pet_license_award_at(new Date().getTime())
                .created_at(new Date().getTime())
                .build();
        log.info("获取宠物信息: " + pet);
        petService.save(pet);
        // 宠物有证
        Map<String, Object> data = new HashMap<>();
        if (petInfo.isHaveLicense()) {
            // 更新疫苗
            PetVaccinate pv = PetVaccinate.builder()
                    .pet_id(pet.getId())
                    .vaccinated_at(petInfo.getVaccinated_at())
                    .vaccine_type(petInfo.getVaccine_type())
                    .created_at(new Date().getTime())
                    .build();
            log.info("获取疫苗信息: " + pv);
            petVaccinateService.save(pv);
            data.put("id", pv.getId());
        }

        return Result.ok(ResultCodeEnum.SUCCESS.getCode(), data);
    }
}
