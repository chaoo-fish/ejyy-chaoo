package com.chaoo.service.basic.controller;

import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 22:06
 */
@Slf4j
@CrossOrigin // 跨域
@RestController
@RequestMapping("/notice")
public class NoticController {

    @GetMapping("/tpl")
    public Result tpl(){
        Map<String,Object> data = new HashMap<>();
        data.put("list","lsit");
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(),data);
    }
}
