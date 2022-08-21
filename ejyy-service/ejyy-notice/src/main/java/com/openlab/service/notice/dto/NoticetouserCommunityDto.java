package com.openlab.service.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticetouserCommunityDto   {
    private Long id;
    private String title;
    private String overview;
    private String content;
    private Long community_id;
    private Integer refer;
    private Long notice_tpl_id;
    private Integer published;
    private Long published_at;
    private Long published_by;
    private Long created_by;
    private Long created_at;
    private String real_name;
}
