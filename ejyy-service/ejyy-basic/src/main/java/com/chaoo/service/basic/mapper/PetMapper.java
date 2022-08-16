package com.chaoo.service.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoo.service.basic.dto.PetDetail;
import com.chaoo.service.basic.entity.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PetMapper extends BaseMapper<Pet> {

    /**
     * 宠物详细信息
     *
     * @return
     */
    @Select("select ejyy_pet.id, " +
            "       ejyy_pet.wechat_mp_user_id, " +
            "       ejyy_pet.name, " +
            "       ejyy_pet.sex, " +
            "       ejyy_pet.pet_type, " +
            "       ejyy_pet.coat_color, " +
            "       ejyy_pet.breed, " +
            "       ejyy_pet.photo, " +
            "       ejyy_pet.pet_license, " +
            "       ejyy_pet.pet_license_award_at, " +
            "       ejyy_community_info.name as community_name, " +
            "       ejyy_pet.remove, " +
            "       ejyy_pet.remove_reason, " +
            "       ejyy_pet.removed_at, " +
            "       ejyy_wechat_mp_user.real_name " +
            "from ejyy_pet " +
            "         left join ejyy_community_info on ejyy_community_info.id = ejyy_pet.community_id " +
            "         left join ejyy_wechat_mp_user on ejyy_wechat_mp_user.id = ejyy_pet.wechat_mp_user_id " +
            "where ejyy_pet.id = #{id} " +
            " and community_id = #{community_id}")
    PetDetail deatil(@Param("id") String id, @Param("community_id") Integer community_id);
}