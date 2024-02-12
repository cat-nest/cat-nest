package com.catnest.user.mapper;

import com.catnest.user.domain.CnUser;

/**
* @author yiwyn
* @description 针对表【cn_user】的数据库操作Mapper
* @createDate 2023-11-13 22:59:13
* @Entity com.catnest.user.domain.CnUser
*/
public interface CnUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CnUser record);

    int insertSelective(CnUser record);

    CnUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CnUser record);

    int updateByPrimaryKey(CnUser record);

}
