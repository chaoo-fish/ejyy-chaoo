package com.chaoo.service.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author chaoo
 * @Date: 2022/08/17/ 18:45
 */
@Data
public class UserListInfo implements Serializable {

    private String department;
    private Long department_id;
    private String job;
    private Long job_id;
    private String real_name;
    private Integer id;
}
