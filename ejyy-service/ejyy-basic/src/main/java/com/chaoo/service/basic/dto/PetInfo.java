package com.chaoo.service.basic.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 21:22
 *
 * 宠物信息
 */
@Data
public class PetInfo {
    private Long user_id;
    private Long community_id;

    @TableField("petType")
    private Integer pet_type;
    private String name;
    private Integer sex;
    private String coat_color;
    private String breed;
    private boolean haveLicense;  // 是否有证
    private String pet_license; // 编号
    private Long pet_license_award_at;
    private String vaccine_type;// 疫苗类型
    private Long vaccinated_at;

}
