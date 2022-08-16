package com.chaoo.service.basic.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 20:22
 * <p>
 * ejyy_building_info ejyy_building_info
 * 通过 用户id 查用户信息
 */
@Data
public class userBuildInfoDto {
    private Long user_building_id; // ejyy_user_building.id
    private boolean authenticated;
    private Integer authenticated_type;
    private Integer type; // 1 住宅 ；2 车位； 3仓房; 4 商户；5 车库
    private String area;
    private String building;
    private String unit;
    private String number;
    private Integer building_id; // ejyy_building_info.id
}
