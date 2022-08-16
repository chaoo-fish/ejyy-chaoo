package com.chaoo.service.basic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 宠物
 * 阉割版
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet implements Serializable {

    private Long id;
    private Long wechat_mp_user_id;
    private Long community_id;
    /**
     * 1 狗
     */
    private Integer pet_type;

    private String name;

    /**
     * 1 公 0 母
     */
    private Integer sex;
    private String photo = "我很漂亮";

    /**
     * 毛色
     */

    private String coat_color;
    private String breed; //品种
    private String pet_license; // 宠物证
    private Long pet_license_award_at = 1660266965660L; // 证书颁发的日期
    private Integer remove; // default 0
    private Integer remove_reason;
    private Long removed_at;
    private Long created_at; // 创建时间
}
