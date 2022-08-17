package com.chaoo.service.user.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/17/ 19:26
 */
@Data
public class UserSelectWork {
    private Long id;
    private String real_name;
    private Long open_id;
    private String subscribed;
}
