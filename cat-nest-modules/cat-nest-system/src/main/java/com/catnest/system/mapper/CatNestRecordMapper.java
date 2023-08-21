package com.catnest.system.mapper;

import com.catnest.system.domain.CatNestRecord;

/**
* @author yiwyn
* @description 针对表【cat_nest_record】的数据库操作Mapper
* @createDate 2023-08-21 22:21:33
* @Entity com.catnest.system.domain.CatNestRecord
*/
public interface CatNestRecordMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CatNestRecord record);

    int insertSelective(CatNestRecord record);

    CatNestRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CatNestRecord record);

    int updateByPrimaryKey(CatNestRecord record);

}
