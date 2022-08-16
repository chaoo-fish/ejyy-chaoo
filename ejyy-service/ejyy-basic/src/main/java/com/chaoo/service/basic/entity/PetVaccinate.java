package com.chaoo.service.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 宠物疫苗
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetVaccinate implements Serializable {

    private Long id;

    private Long pet_id;

    private Long vaccinated_at;

    private String vaccine_type;

    private Long created_at;
}