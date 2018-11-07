package com.atguigu.crowd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aguigu.crowd.beam.User;
import com.atguigu.crowd.service.UserService;


@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@Autowired
	private UserService userService;
	

	@ResponseBody
	@RequestMapping("/queryAll")
	public Object queryAll() {
		List<User> users =  userService.queryAll();
		return users;
	}
	@RequestMapping("/htmltest")
	public String htmltest() {
		return "thymeleaf/index";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/json")
	public Object json() {
		Map map =new HashMap();
		map.put("username", "123");
		return map;
	}
}
