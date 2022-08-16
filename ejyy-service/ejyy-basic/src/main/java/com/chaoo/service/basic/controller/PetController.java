package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.chaoo.common.utils.Result;
import com.chaoo.service.basic.dto.PetInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 21:17
 */
@Slf4j
@CrossOrigin // 跨域
@RestController
@RequestMapping("/pet")
public class PetController {

    @PostMapping("/create")
    public Result create(@RequestBody String json){
        PetInfo petInfo = JSON.parseObject(json, PetInfo.class);
        System.out.println("petInfo = " + petInfo);

        return Result.ok(300,"yes");
    }
}
