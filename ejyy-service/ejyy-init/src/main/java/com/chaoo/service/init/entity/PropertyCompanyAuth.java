package com.chaoo.service.init.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyCompanyAuth implements Serializable {
    private Long id;
    private Long propertyCompanyUserId; // 公司用户编号
    private String token; // 令牌
}
