package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.chaoo.common.utils.Result;
import com.chaoo.service.basic.dto.PhoneDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 19:51
 */
@Slf4j
@CrossOrigin // 跨域
@RestController
@RequestMapping("/option")
public class OptionController {

    /**
     * 检查业主是否存在
     * @return
     */
    @PostMapping("/ower")
    public Result checkPhone(@RequestBody String json){
        PhoneDto phoneDto = JSON.parseObject(json, PhoneDto.class);
        System.out.println("phoneDto = " + phoneDto);

        return Result.ok();
    }
}
