package com.chaoo.service.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoo.service.user.dto.CommunityDto;
import com.chaoo.service.user.dto.CommunityList;
import com.chaoo.service.user.entity.CommunityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 小区信息
 */
@Repository
public interface CommunityInfoMapper extends BaseMapper<CommunityInfo> {
    // 根据用户编号查询小区设置信息
    @Select("select ejyy_community_setting.community_id," +
            "ejyy_community_setting.access_nfc," +
            "ejyy_community_setting.access_qrcode," +
            "ejyy_community_setting.access_remote," +
            "ejyy_community_setting.fitment_pledge," +
            "ejyy_community_info.name " +
            "from ejyy_community_info left join ejyy_community_setting on ejyy_community_setting.community_id=ejyy_community_info.id " +
            "where ejyy_community_info.id in (" +
            "  select community_id " +
            "  from ejyy_property_company_user_access_community " +
            "  where property_company_user_id=#{userId}" +
            ")")
    CommunityDto communityInfo(@Param("userId") Long userId);
}