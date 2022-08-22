package com.openlab.service.notice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.openlab.service.notice.dto.NoticetouserCommunityDto;
import com.openlab.service.notice.entity.NoticeToUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeToUserMapper extends BaseMapper<NoticeToUser> {
    @Select("SELECT ejyy_notice_to_user.*, ejyy_property_company_user.real_name " +
            "FROM ejyy_notice_to_user, ejyy_property_company_user" +
            " WHERE ejyy_notice_to_user.community_id = ejyy_property_company_user.id order by id " +
            "limit #{num},#{size};  ")
    List<NoticetouserCommunityDto> getpage(@Param("num")int num, @Param("size")int size);
    @Select("SELECT ejyy_notice_to_user.*, ejyy_property_company_user.real_name " +
            "FROM ejyy_notice_to_user, ejyy_property_company_user " +
            "WHERE ejyy_notice_to_user.community_id = ejyy_property_company_user.id " +
            "and published LIKE #{published} order by id " +
            "limit #{num},#{size}; ")
    List<NoticetouserCommunityDto> getpageL(@Param("num")int num, @Param("size")int size,@Param("published") int published);
    @Select("SELECT COUNT(*) FROM ejyy_notice_to_user, ejyy_property_company_user " +
            "WHERE ejyy_notice_to_user.community_id = ejyy_property_company_user.id " +
            "and published LIKE #{published} ;   ")
    Integer gettotalL(@Param("published") int published);
    @Select("SELECT COUNT(*) FROM ejyy_notice_to_user, ejyy_property_company_user " +
            "WHERE ejyy_notice_to_user.community_id = ejyy_property_company_user.id ;")
    Integer gettotal();

}
