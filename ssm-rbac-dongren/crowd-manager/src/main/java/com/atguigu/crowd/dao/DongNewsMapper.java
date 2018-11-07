package com.atguigu.crowd.dao;

import java.util.List;
import java.util.Map;

import com.aguigu.crowd.beam.DongNews;

public interface DongNewsMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(DongNews record);

    int insertSelective(DongNews record);

    DongNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DongNews record);

    int updateByPrimaryKey(DongNews record);

	List<DongNews> pageQuery(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	void deletedongNewss(Map<String, Object> map);

	List<DongNews> queryByColumnId(int i);
}