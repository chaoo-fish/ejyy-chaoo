package com.chaoo.common.execptionhandler;

import com.chaoo.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chaoo
 * @Date: 2022/08/14/ 9:30
 *
 * 全局异常通知
 */
@Slf4j
@ControllerAdvice
public class GlobalException {
    // 处理自定义异常
    @ExceptionHandler(CustomerException.class)
    @ResponseBody
    public Result error(CustomerException e) {
        log.error("{}",e.getMessage());
        return Result.error().message(e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        log.error("{}",e.getMessage());
        return Result.error().message("执行了算术异常ArithmeticException处理");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        log.error("{}",e.getMessage());
        return Result.error().message("执行全局异常Exception处理");
    }
}
