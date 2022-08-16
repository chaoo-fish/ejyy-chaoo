package com.chaoo.service.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 14:20
 *
 * 业主档案
 */

@Slf4j
@CrossOrigin // 允许跨域
@RestController
@RequestMapping("/ower")
public class OwerController {

    public String list(){

        return "testList";
    }
}
