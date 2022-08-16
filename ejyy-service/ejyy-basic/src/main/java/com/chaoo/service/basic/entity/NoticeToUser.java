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
    private Long communityId;
    /**
     * 1 物业公司 2 系统
     */
    private Boolean refer;
    private Long noticeTplId;
    private Boolean published;
    private Long publishedAt;
    private Long publishedBy;
    private Long createdBy;
    private Long createdAt;
}