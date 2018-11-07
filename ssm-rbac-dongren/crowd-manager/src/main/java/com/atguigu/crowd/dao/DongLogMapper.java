package com.atguigu.crowd.dao;

import java.util.List;
import java.util.Map;

import com.aguigu.crowd.beam.DongLog;

public interface DongLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DongLog record);

    int insertSelective(DongLog record);

    DongLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DongLog record);

    int updateByPrimaryKey(DongLog record);

	List<DongLog> selectOneDay(Map<String, Object> map);
}