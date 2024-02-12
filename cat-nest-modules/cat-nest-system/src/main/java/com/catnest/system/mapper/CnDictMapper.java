package com.catnest.system.mapper;


import com.catnest.system.domain.CnDict;

/**
 * @author yiwyn
 * @description 针对表【cn_dict(系统字典表)】的数据库操作Mapper
 * @createDate 2023-11-29 23:49:06
 * @Entity com.catnest.user.domain.CnDict
 */
public interface CnDictMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CnDict record);

    int insertSelective(CnDict record);

    CnDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CnDict record);

    int updateByPrimaryKey(CnDict record);

}
