package com.openlab.service.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公司员工
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyCompanyUser implements Serializable {
    private Integer id;
    private String account;
    private String password;
    private String open_id;
    private String union_id;
    private String real_name;
    private String idcard;
    private boolean gender;
    private String avatar_url = "/avatar/default.png";
    private String phone;
    private Long department_id;
    private Long job_id;
    private Long access_id;
    private boolean admin;
    private Long join_company_at;
    private boolean leave_office;
    private Long created_by;
    private Long created_at;
}