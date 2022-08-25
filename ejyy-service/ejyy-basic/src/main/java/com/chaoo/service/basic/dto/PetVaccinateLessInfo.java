package com.chaoo.service.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author chaoo
 * @Date: 2022/08/16/ 16:17
 *
 * 返回宠物详细信息的疫苗信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetVaccinateLessInfo implements Serializable {
    private Long vaccinated_at;
    private String vaccine_type;
}
