package com.atguigu.crowd.service;

import java.util.List;

import com.aguigu.crowd.beam.Permission;
import com.aguigu.crowd.beam.User;



public interface PermissionService {

	Permission queryRootPermission();

	List<Permission> queryChildPermissions(Integer pid);

	List<Permission> queryAll();

	void insertPermission(Permission permission);

	Permission queryById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Permission permission);

	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	List<Permission> queryPermissionsByUser(User dbUser);

}
