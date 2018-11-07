package com.atguigu.crowd.dao;

import java.util.List;

import com.aguigu.crowd.beam.DongSearch;

public interface DongSearchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DongSearch record);

    int insertSelective(DongSearch record);

    DongSearch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DongSearch record);

    int updateByPrimaryKey(DongSearch record);

	List<DongSearch> selecthotsearch();
}