package com.atguigu.crowd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.aguigu.crowd.beam.Role;



public interface RoleDao {

	List<Role> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	@Select("select * from t_role")
	List<Role> queryAll();

	void insertRolePermission(Map<String, Object> paramMap);

	void deleteRolePermissions(Map<String, Object> paramMap);

}
