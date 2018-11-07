package com.atguigu.crowd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguigu.crowd.beam.DongColumn;
import com.aguigu.crowd.beam.DongNews;
import com.atguigu.crowd.dao.DongColumnMapper;
import com.atguigu.crowd.dao.DongNewsMapper;
import com.atguigu.crowd.service.DongNewsService;

@Service
public class DongNewsServiceImpl implements DongNewsService{

	@Autowired
	private DongNewsMapper dongNewsMapper;
	
	public DongNews queryAll() {
		// TODO Auto-generated method stub
		return dongNewsMapper.selectByPrimaryKey(1);
	}

	public void insert(DongNews dongNews) {
		// TODO Auto-generated method stub
		dongNewsMapper.insert(dongNews);
	}

	public List<DongNews> pageQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dongNewsMapper.pageQuery(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dongNewsMapper.pageQueryCount(map);
	}

	public DongNews queryById(Integer id) {
		// TODO Auto-generated method stub
		return dongNewsMapper.selectByPrimaryKey(id);
	}

	public void updateDongNews(DongNews dongNews) {
		// TODO Auto-generated method stub
		dongNewsMapper.updateByPrimaryKeySelective(dongNews);
	}

	public void deleteDongNewsById(Integer id) {
		// TODO Auto-generated method stub
		dongNewsMapper.deleteByPrimaryKey(id);
	}

	public void deletedongNewss(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dongNewsMapper.deletedongNewss(map);
	}

	public List<DongNews> queryByColumnId(int i) {
		// TODO Auto-generated method stub
		return dongNewsMapper.queryByColumnId(i);
	}

	
}
