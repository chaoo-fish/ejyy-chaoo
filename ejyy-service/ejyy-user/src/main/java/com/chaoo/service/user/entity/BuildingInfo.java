package com.chaoo.service.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 房子
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingInfo implements Serializable {
    private Integer id;
    private Long community_id;
    private Integer type;
    private String area;
    private String building;
    private String unit;
    private String number;
    private Float construction_area;
    private Long created_by;
    private Long created_at;
}
