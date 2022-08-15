package com.chaoo.common.execptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chaoo
 * @Date: 2022/08/14/ 9:26
 *
 * 自定义异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerException extends RuntimeException{
    private Integer code; // 状态码
    private String msg; // 异常信息
}
