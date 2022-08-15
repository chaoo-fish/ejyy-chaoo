package com.chaoo.service.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门和职位
 */
@Data
public class DepartJob implements Serializable {
    private String department; // 部门名称
    private String job; // 职位名称
}
