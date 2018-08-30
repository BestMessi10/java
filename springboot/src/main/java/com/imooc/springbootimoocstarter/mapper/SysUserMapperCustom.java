package com.imooc.springbootimoocstarter.mapper;

import com.imooc.springbootimoocstarter.pojo.SysUser;
import com.imooc.springbootimoocstarter.pojo.TestPojo1;
import com.imooc.springbootimoocstarter.pojo.TestRegion;

import java.util.List;


public interface SysUserMapperCustom {

	List<SysUser> queryUserSimplyInfoById(String id);
	TestPojo1 queryTest1();
	List<TestRegion>  queryRegion(String id);
}