package com.atguigu.crowd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguigu.crowd.beam.DongLog;
import com.aguigu.crowd.beam.DongSearch;
import com.aguigu.crowd.beam.User;
import com.atguigu.crowd.dao.DongLogMapper;
import com.atguigu.crowd.dao.DongSearchMapper;
import com.atguigu.crowd.dao.UserDao;
import com.atguigu.crowd.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DongSearchMapper dongSearchMapper;
	
	@Autowired
	private DongLogMapper dongLogMapper;

	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}

	public User query4Login(User user) {
		// TODO Auto-generated method stub
		return userDao.query4Login(user);
	}

	public List<User> pageQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.pageQuery(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.pageQueryCount(map);
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}

	public User queryById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryById(id);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		userDao.deleteUserById(id);
	}

	public void deleteUsers(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.deleteUsers(map);
	}

	public void insertUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.insertUserRoles(map);
	}

	public void deleteUserRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.deleteUserRoles(map);
	}

	public List<Integer> queryRoleidsByUserid(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryRoleidsByUserid(id);
	}

	public User query5Login(User user) {
		// TODO Auto-generated method stub
		return userDao.query5Login(user);
	}

	public void insertlog(DongLog dongLog) {
		// TODO Auto-generated method stub
		dongLogMapper.insertSelective(dongLog);
	}

	public List<DongLog> selectOneDay(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dongLogMapper.selectOneDay(map);
	}

	public void inseartSearch(DongSearch dongSearch) {
		// TODO Auto-generated method stub
		dongSearchMapper.insertSelective(dongSearch);
	}

	public List<DongSearch> selecthotsearch() {
		// TODO Auto-generated method stub
		return dongSearchMapper.selecthotsearch();
	}
}
