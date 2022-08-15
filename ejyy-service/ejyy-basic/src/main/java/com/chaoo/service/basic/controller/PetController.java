package com.chaoo.service.basic.controller;

import com.chaoo.common.utils.Result;
import com.chaoo.service.basic.dto.PetInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result create(PetInfo petInfo){
        System.out.println("petInfo = " + petInfo);

        return Result.ok(300,"yes");
    }
}
