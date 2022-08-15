package com.chaoo.service.user.dto;

import lombok.Data;

/**
 * 查询小区设置传输类
 */
@Data
public class CommunityDto {
    private Long communityId;
    private boolean accessNfc;
    private boolean accessQrcode;
    private boolean accessRemote;
    private boolean fitmentPledge;
    private String name;
}
