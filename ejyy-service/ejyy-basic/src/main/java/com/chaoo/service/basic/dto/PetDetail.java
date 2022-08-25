package com.chaoo.service.basic.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author chaoo
 * @Date: 2022/08/16/ 15:42
 *
 * 多表查询的宠物详细信息
 */
@Data
public class PetDetail implements Serializable {
    private Long id;
    private Long wechat_mp_user_id;
    private String name;
    private Integer sex;
    private Integer pet_type;
    private String coat_color;
    private String breed;
    private String photo;
    private String pet_license;
    private Long pet_license_award_at;
    private String community_name;
    private Integer remove;
    private Integer remove_reason;
    private Long removed_at;
    private String real_name;

}
