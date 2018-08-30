package com.imooc.springbootimoocstarter.controller;

import java.util.Date;
import java.util.List;

import com.imooc.springbootimoocstarter.pojo.IMoocJSONResult;
import com.imooc.springbootimoocstarter.pojo.SysUser;
import com.imooc.springbootimoocstarter.pojo.TestRegion;
import com.imooc.springbootimoocstarter.service.UserService;
import org.n3r.idworker.Sid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public IMoocJSONResult saveUser() throws Exception {

		//id生成器 可以保证唯一
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(1);
		user.setUsername("imooc" + new Date());
		user.setNickname("imooc" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public IMoocJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId(1);
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public IMoocJSONResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return IMoocJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public IMoocJSONResult queryUserById(String userId) {
		return IMoocJSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public IMoocJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return IMoocJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public IMoocJSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 3;
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return IMoocJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public IMoocJSONResult queryUserByIdCustom(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public IMoocJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(007);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	@RequestMapping("/test1")
	public IMoocJSONResult queryTest(){
		return IMoocJSONResult.ok(userService.queryTest());
	}
	@RequestMapping("/testRegion")
	public List<TestRegion> queryRegion(String id){
		return userService.queryRegion(id);
	}
}
