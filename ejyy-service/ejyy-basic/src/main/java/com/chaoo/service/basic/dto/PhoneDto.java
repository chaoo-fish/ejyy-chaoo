package com.chaoo.service.basic.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 19:55
 *
 * 接收前端传来的数据
 */
@Data
public class PhoneDto {
    private String community_id;
    private String phone;
}
