package com.atguigu.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguigu.crowd.beam.DongColumn;
import com.atguigu.crowd.dao.DongColumnMapper;
import com.atguigu.crowd.dao.DongNewsMapper;
import com.atguigu.crowd.service.DongColumnService;

@Service
public class DongColumnServiceImpl implements DongColumnService{
	
	@Autowired
	private DongColumnMapper dongColumnMapper;

	public List<DongColumn> querycolumn() {
		// TODO Auto-generated method stub
		return dongColumnMapper.querycolumn();
	}

}
