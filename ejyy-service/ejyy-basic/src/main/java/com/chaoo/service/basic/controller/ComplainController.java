package com.chaoo.service.basic.controller;

import com.chaoo.common.utils.Result;
import com.chaoo.service.basic.dto.ComplainInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chaoo
 * @Date: 2022/08/17/ 13:32
 *
 * 投诉模块
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/complain")
public class ComplainController {

    @PostMapping("/create")
    public Result create(@RequestBody ComplainInfo complainInfo){
        log.info("complainInfo: " + complainInfo);

        return Result.ok();
    }
}
