package com.chaoo.service.basic.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chaoo.common.utils.Result;
import com.chaoo.common.utils.ResultCodeEnum;
import com.chaoo.service.basic.dto.NoticInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 22:06
 *
 * 小区通知
 */
@Slf4j
@CrossOrigin // 跨域
@RestController
@RequestMapping("/notice")
public class NoticController {


    @PostMapping("/create")
    public Result create(@RequestBody String json){
        NoticInfo noticInfo = JSON.parseObject(json, NoticInfo.class);
        System.out.println(noticInfo);

        return Result.ok();
    }


    /**
     * 微信公众号获取模板
     * 因本功能暂不做公众号，故返回假数据
     * @return
     */
    @GetMapping("/tpl")
    public Result tpl(){
        Map<String,Object> data = new HashMap<>();
        data.put("list","list");
        log.info("返回模板");
        return Result.ok(ResultCodeEnum.SUCCESS.getCode(),data);
    }
}
