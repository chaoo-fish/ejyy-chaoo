package com.chaoo.service.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 宠物
 * 更改返回给前端的数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetJson implements Serializable {

    private Long id;
    private Long wechatMpUserId;
    private Long communityId;
    private Integer pet_type;
    private String name;
    private Integer sex;
    private String photo = "我很漂亮";
    private String coat_color;
    private String breed; //品种
    private String pet_license; // 宠物证
    private Long pet_license_award_at;
    private Boolean remove; // default 0
    private Integer remove_reason;
    private Long removed_at;
    private Long created_at; // 创建时间
}
