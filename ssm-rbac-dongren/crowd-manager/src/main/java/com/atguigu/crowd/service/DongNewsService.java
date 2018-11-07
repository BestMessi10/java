package com.atguigu.crowd.service;

import java.util.List;
import java.util.Map;

import com.aguigu.crowd.beam.DongNews;

public interface DongNewsService {

	DongNews queryAll();

	void insert(DongNews dongNews);

	List<DongNews> pageQuery(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	DongNews queryById(Integer id);

	void updateDongNews(DongNews dongNews);

	void deleteDongNewsById(Integer id);

	void deletedongNewss(Map<String, Object> map);

	List<DongNews> queryByColumnId(int i);

}
