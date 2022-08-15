package com.chaoo.common.utils;

import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回状态码
 */
@Data
public class Result {
    private int code; // 状态码
    private boolean success; // 是否成功标识
    private String message; // 结果提示信息
    private Map<String, Object> data = new HashMap<>(); // 结果数据集

    // 构造方法私有化
    private Result() {
    }

    // 成功的静态方法
    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    public static Result ok(Map<String, Object> data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static Result ok(int code, String message, Map<String, Object> data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static Result ok(int code, Map<String, Object> data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public static Result ok(int code, String mes) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(mes);
        return result;
    }

    public static Result ok(ResultCodeEnum re) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(re.getCode());
        result.setMessage(re.getMessage());
        return result;
    }

    // 只设置标识
    public static Result success(boolean success) {
        Result result = new Result();
        result.setSuccess(success);
        return result;
    }

    // 只设置消息
    public Result message(String message) {
        Result result = new Result();
        result.setMessage(message);
        return result;
    }

    // 只设置状态码
    public static Result code(int code) {
        Result result = new Result();
        result.setCode(code);
        return result;
    }

    // 设置返回结果集
    public static Result data(String key, Object value) {
        Result result = new Result();
        result.getData().put(key, value);
        return result;
    }

    public static Result map(Map<String, Object> map) {
        Result result = new Result();
        result.setData(map);
        return result;
    }

    // 失败静态方法
    public static Result error() {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(20001);
        result.setMessage("失败");
        return result;
    }
}