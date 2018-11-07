package com.atguigu.crowd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.aguigu.crowd.beam.DongColumn;

public interface DongColumnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DongColumn record);

    int insertSelective(DongColumn record);

    DongColumn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DongColumn record);

    int updateByPrimaryKey(DongColumn record);

    @Select("select * from d_column")
	List<DongColumn> querycolumn();
}