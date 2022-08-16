package com.chaoo.service.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chaoo
 * @Date: 2022/08/16/ 15:42
 *
 * 返回前端多表查询的宠物详细信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDetailJson {
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
