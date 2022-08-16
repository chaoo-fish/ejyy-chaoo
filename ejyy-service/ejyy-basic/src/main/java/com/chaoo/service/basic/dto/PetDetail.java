package com.chaoo.service.basic.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/16/ 15:42
 *
 * 多表查询的宠物详细信息
 */
@Data
public class PetDetail {
    private Long id;
    private Long wechatMpUserId;
    private String name;
    private Integer sex;
    private Integer petType;
    private String coatColor;
    private String breed;
    private String photo;
    private String petLicense;
    private Long petLicenseAwardAt;
    private String communityName;
    private Integer remove;
    private Integer removeReason;
    private Long removedAt;
    private String realName;

}
