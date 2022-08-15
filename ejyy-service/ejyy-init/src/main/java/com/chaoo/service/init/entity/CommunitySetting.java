package com.chaoo.service.init.entity;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunitySetting implements Serializable {
    private Long id;
    private Long communityId; // 小区ID
    private boolean accessNfc; // NFC门禁
    private boolean accessQrcode; // 二维码门禁
    private boolean accessRemote; // 远程开门
    private int carportMaxCar; //
    private int garageMaxCar; //车库
    private boolean fitmentPledge; // 装修保证金
}