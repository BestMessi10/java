package com.atguigu.crowd.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguigu.crowd.beam.Role;
import com.atguigu.crowd.dao.RoleDao;
import com.atguigu.crowd.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;


	public List<Role> pageQueryData(Map<String, Object> map) {
		return roleDao.pageQueryData(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		return roleDao.pageQueryCount(map);
	}

	public List<Role> queryAll() {
		return roleDao.queryAll();
	}

	public void insertRolePermission(Map<String, Object> paramMap) {
		roleDao.deleteRolePermissions(paramMap);
		roleDao.insertRolePermission(paramMap);
	}

}
