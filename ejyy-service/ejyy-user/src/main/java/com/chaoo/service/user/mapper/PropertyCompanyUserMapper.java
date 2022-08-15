package com.chaoo.service.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoo.service.user.dto.DepartJob;
import com.chaoo.service.user.dto.LoginInfo;
import com.chaoo.service.user.entity.PropertyCompanyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author chaoo
 * @Date: 2022/08/12/ 10:46
 *
 * 用户
 */
@Mapper
public interface PropertyCompanyUserMapper extends BaseMapper<PropertyCompanyUser> {
    // 登录信息
    @Select("select ejyy_property_company_user.id id, " +
            "ejyy_property_company_user.account account, " +
            "ejyy_property_company_user.password password, " +
            "ejyy_property_company_user.open_id open_id, " +
            "ejyy_property_company_user.real_name real_name, " +
            "ejyy_property_company_user.gender gender, " +
            "ejyy_property_company_user.avatar_url avatar_url, " +
            "ejyy_property_company_user.phone phone, " +
            "ejyy_property_company_user.department_id department_id, " +
            "ejyy_property_company_user.job_id job_id, " +
            "ejyy_property_company_user.join_company_at join_company_at, " +
            "ejyy_property_company_user.admin admin, " +
            "ejyy_property_company_user.created_at created_at, " +
            "ejyy_wechat_official_accounts_user.subscribed subscribed, " +
            "ejyy_property_company_access.content content " +
            "from ejyy_property_company_user left join ejyy_wechat_official_accounts_user on ejyy_wechat_official_accounts_user.union_id=ejyy_property_company_user.union_id " +
            "left join ejyy_property_company_access on ejyy_property_company_access.id= ejyy_property_company_user.access_id " +
            "where ejyy_property_company_user.leave_office=false and ejyy_property_company_user.account=#{account}")
    LoginInfo login(@Param("account") String account);

    // 查询部门和职位
    @Select("select ejyy_property_company_department.name as department, " +
            "ejyy_property_company_job.name as job " +
            "from ejyy_property_company_user left join ejyy_property_company_department on ejyy_property_company_department.id=ejyy_property_company_user.department_id " +
            "left join ejyy_property_company_job on ejyy_property_company_job.id=ejyy_property_company_user.job_id " +
            "where ejyy_property_company_user.id=#{userId}")
    DepartJob getInfoByUserId(@Param("userId") Integer userId);

}
