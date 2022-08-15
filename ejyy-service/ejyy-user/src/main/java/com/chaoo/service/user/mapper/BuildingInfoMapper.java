package com.chaoo.service.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoo.service.user.entity.BuildingInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingInfoMapper extends BaseMapper<BuildingInfo> {

    @Select("select count(*) from ejyy_building_info where community_id=#{community_id} and type=1 and id in(" +
            "select ejyy_user_building.building_id from ejyy_user_building left join ejyy_building_info on ejyy_building_info.id=ejyy_user_building.building_id " +
            "where ejyy_building_info.community_id=${community_id} and ejyy_building_info.type=1 and ejyy_user_building.status=2)")
    Long houseBindingTotal(Long community_id);

    @Select("select count(*) from ejyy_building_info where community_id=#{community_id} and type=2 and id in(" +
            "select ejyy_user_building.building_id from ejyy_user_building left join ejyy_building_info on ejyy_building_info.id=ejyy_user_building.building_id " +
            "where ejyy_building_info.community_id=${community_id} and ejyy_building_info.type=2 and ejyy_user_building.status=1)")
    Long carportBindingTotal(Long community_id);

    @Select("select count(*) from ejyy_building_info where community_id=#{community_id} and type=3 and id in(" +
            "select ejyy_user_building.building_id from ejyy_user_building left join ejyy_building_info on ejyy_building_info.id=ejyy_user_building.building_id " +
            "where ejyy_building_info.community_id=${community_id} and ejyy_building_info.type=3 and ejyy_user_building.status=1)")
    Long warehouseBindingTotal(Long community_id);

    @Select("select count(*) from ejyy_building_info where community_id=#{community_id} and type=4 and id in(" +
            "select ejyy_user_building.building_id from ejyy_user_building left join ejyy_building_info on ejyy_building_info.id=ejyy_user_building.building_id " +
            "where ejyy_building_info.community_id=${community_id} and ejyy_building_info.type=4 and ejyy_user_building.status=1)")
    Long merchantBindingTotal(Long community_id);

    @Select("select count(*) from ejyy_building_info where community_id=#{community_id} and type=5 and id in(" +
            "select ejyy_user_building.building_id from ejyy_user_building left join ejyy_building_info on ejyy_building_info.id=ejyy_user_building.building_id " +
            "where ejyy_building_info.community_id=${community_id} and ejyy_building_info.type=5 and ejyy_user_building.status=1)")
    Long garageBindingTotal(Long community_id);


    @Select("select count(*) from ejyy_wechat_mp_user where id in (" +
            "select ejyy_user_building.wechat_mp_user_id from ejyy_user_building left join ejyy_building_info on ejyy_building_info.id=ejyy_user_building.building_id " +
            "where ejyy_building_info.community_id=#{community_id} and ejyy_user_building.status=1)")
    Long owerTotal(Long community_id);


    @Select("select count(*) from ejyy_user_car where status=1 and building_id in (" +
            "select id from ejyy_building_info where community_id=#{community_id} and type=2)")
    Long carTotal(Long community_id);

    @Select("select count(*) from ejyy_pet where community_id=#{community_id}")
    Long petTotal(Long community_id);
}