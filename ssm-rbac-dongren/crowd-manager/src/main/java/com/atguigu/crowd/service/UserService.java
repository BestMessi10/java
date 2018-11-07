package com.atguigu.crowd.service;

import java.util.List;
import java.util.Map;

import com.aguigu.crowd.beam.DongLog;
import com.aguigu.crowd.beam.DongSearch;
import com.aguigu.crowd.beam.User;

public interface UserService {

	List<User> queryAll();

	User query4Login(User user);

	List<User> pageQuery(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	void insertUser(User user);

	User queryById(Integer id);

	void updateUser(User user);

	void deleteUserById(Integer id);

	void deleteUsers(Map<String, Object> map);

	void insertUserRoles(Map<String, Object> map);

	void deleteUserRoles(Map<String, Object> map);

	List<Integer> queryRoleidsByUserid(Integer id);

	User query5Login(User user);

	void insertlog(DongLog dongLog);

	List<DongLog> selectOneDay(Map<String, Object> map);

	void inseartSearch(DongSearch dongSearch);

	List<DongSearch> selecthotsearch();

}
