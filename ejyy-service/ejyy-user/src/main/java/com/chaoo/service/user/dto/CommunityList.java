package com.chaoo.service.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* 小区设置信息传输对象
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityList implements Serializable {
    private Long community_id;
    private Integer access_nfc;
    private Integer access_qrcode;
    private Integer access_remote;
    private Integer fitment_pledge;
    private String name;
}
