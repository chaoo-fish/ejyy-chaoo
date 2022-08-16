package com.chaoo.service.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通知类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeTpl implements Serializable {
    private Long id;
    private String tpl;
    private String content;
}