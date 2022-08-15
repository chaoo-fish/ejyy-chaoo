package com.chaoo.service.basic.entity;

import java.io.Serializable;

public class UserBuilding implements Serializable {

    private Long id;

    private Long buildingId;

    private Long wechatMpUserId;

    private Boolean authenticated;

    /**
     * 1 实名信息自行关联;2 物业公司认证 3 业主认证
     */
    private Integer authenticatedType;

    /**
     * 根据type查询认证用户
     */
    private Long authenticatedUserId;

    /**
     * 1 正常;0 解绑
     */
    private Integer status;

    private Long createdAt;


}