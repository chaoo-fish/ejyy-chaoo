package com.chaoo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chaoo
 * @Date: 2022/08/14/ 10:03
 *
 * 封装从 Token 中获取的的对象属性
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTokenDto {
    private  String id;
    private String name;
}
