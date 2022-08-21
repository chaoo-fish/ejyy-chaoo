package com.openlab.service.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeTpl implements Serializable {
    Integer id;
    String tpl;
    String contnt;
}
