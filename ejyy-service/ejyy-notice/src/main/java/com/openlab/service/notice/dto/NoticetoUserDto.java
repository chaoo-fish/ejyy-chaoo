package com.openlab.service.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticetoUserDto implements Serializable {

    private Long id;


    private String title;//": "111",
    private String overview;//": "111",
    private Integer published;//": 0,
    private String oa_tpl_msg;//": false,
    private String tpl;//": "",
    private Object tpl_content;//": [],
    private Object content;//":*/
    private Long community_id;//": 6
}

