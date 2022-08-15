package com.chaoo.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoo.service.user.entity.BuildingInfo;

public interface BuildingInfoService extends IService<BuildingInfo> {
    Long houseBindingTotal(Long community_id);

    Long carportBindingTotal(Long community_id);

    Long warehouseBindingTotal(Long community_id);

    Long merchantBindingTotal(Long community_id);

    Long garageBindingTotal(Long community_id);

    Long owerTotal(Long community_id);

    Long carTotal(Long community_id);

    Long petTotal(Long community_id);
}