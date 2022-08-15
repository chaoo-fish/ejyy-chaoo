package com.chaoo.service.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoo.service.basic.dto.userBuildInfoDto;
import com.chaoo.service.basic.entity.UserBuilding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserBuildingMapper extends BaseMapper<UserBuilding> {

    /**
     * 查找业主信息
     * @return
     */
    @Select("select  ejyy_user_building.id as user_building_id , " +
            "                 ejyy_user_building.authenticated , " +
            "                 ejyy_user_building.authenticated_type , " +
            "                 ejyy_building_info.type , " +
            "                 ejyy_building_info.area , " +
            "                 ejyy_building_info.building , " +
            "                 ejyy_building_info.unit , " +
            "                 ejyy_building_info.number , " +
            "                 ejyy_building_info.id as building_id  " +
            "from ejyy_user_building " +
            "         left join ejyy_building_info on ejyy_building_info.id = ejyy_user_building.building_id " +
            "where ejyy_user_building.wechat_mp_user_id = #{wuserId} " +
            "and ejyy_user_building.status = 1 " + // 1 是用户住宅
            "and ejyy_building_info.community_id = #{bcommunityId} " +
            "order by ejyy_user_building.id desc")
    List<userBuildInfoDto> selectBuild(@Param("wuserId") Long wuserId,@Param("bcommunityId") Long bcommunityId);

}
