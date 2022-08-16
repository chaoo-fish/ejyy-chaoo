package com.chaoo.service.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

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

    private Long wechatMpUserId;

    private Long communityId;

    /**
     * 1 狗
     */
    private Integer petType;

    private String name;

    /**
     * 1 公 0 母
     */
    private Integer sex;

    private String photo = "我很漂亮";

    /**
     * 毛色
     */
    private String coatColor;

    private String breed; //品种

    private String petLicense = "666";

    private Long petLicenseAwardAt = 1660266965660L; // 证书颁发的日期

    private Boolean remove; // default 0

    private Integer removeReason;

    private Long removedAt;

    private Long createdAt; // 创建时间


}
