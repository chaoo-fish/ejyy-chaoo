package com.chaoo.service.basic.entity;

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
public class NoticeToUser implements Serializable {
    private Long id;
    private String title;
    private String overview;
    private String content;
    private Long community_id;
    /**
     * 1 物业公司 2 系统
     */
    private Integer refer;
    private Long notice_tpl_id;
    private Integer published;
    private Long published_at;
    private Long published_by;
    private Long created_by;
    private Long created_at;
}