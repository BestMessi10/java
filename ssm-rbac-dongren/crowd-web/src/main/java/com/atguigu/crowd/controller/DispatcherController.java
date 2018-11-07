package com.atguigu.crowd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aguigu.crowd.beam.AJAXResult;
import com.aguigu.crowd.beam.DongLog;
import com.aguigu.crowd.beam.Permission;
import com.aguigu.crowd.beam.User;
import com.atguigu.crowd.service.PermissionService;
import com.atguigu.crowd.service.UserService;



@Controller
public class DispatcherController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/regist")
	public String regist() {
		return "regist";
	}
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginUser");
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	@ResponseBody
	@RequestMapping("/doAJAXRegist")
	public Object doAJAXRegist(User user, HttpSession session) {
		AJAXResult result = new AJAXResult();
		
		try {
			User dbUser = userService.query5Login(user);
			if (dbUser ==null)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				user.setCreatetime(sdf.format(new Date()));
				userService.insertUser(user);
				
				//初始化角色，给用户分配角色
				Integer[] unassignroleids = {3};
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userid", user.getId());
				map.put("roleids", unassignroleids);
				userService.insertUserRoles(map);
				//记录日志
				DongLog dongLog =new DongLog();
				dongLog.setUserid(user.getId());
				dongLog.setType(0);
				dongLog.setTime(sdf.format(new Date()));
				userService.insertlog(dongLog);
				result.setSuccess(true);
				
			}else {
				result.setSuccess(false);
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	@ResponseBody
	@RequestMapping("/doAJAXLogin")
	public Object doAJAXLogin(User user, HttpSession session) {
		
		AJAXResult result = new AJAXResult();
		
		User dbUser = userService.query4Login(user);
		if ( dbUser != null ) {
			session.setAttribute("loginUser", dbUser);
			result.setSuccess(true);
			// 获取用户权限信息
			List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
			Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
			Permission root = null;
			Set<String> uriSet = new HashSet<String>();
			for ( Permission permission : permissions ) {
				permissionMap.put(permission.getId(), permission);
				if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
					uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
				}
			}
			//权限集合
			session.setAttribute("authUriSet", uriSet);
			for ( Permission permission : permissions ) {
				Permission child = permission;
				if ( child.getPid() == 0 ) {
					root = permission;
				} else {
					Permission parent = permissionMap.get(child.getPid());
					parent.getChildren().add(child);
				}
			}
			//树
			session.setAttribute("rootPermission", root);
			//记录日志
			DongLog dongLog =new DongLog();
			dongLog.setUserid(dbUser.getId());
			dongLog.setType(1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dongLog.setTime(sdf.format(new Date()));
			userService.insertlog(dongLog);
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/doLogin")
	public String doLogin( User user, Model model ) throws Exception {
		
		String loginacct = user.getLoginacct();
		

		// 将乱码字符串按照错误的编码方式转换为原始的字节码序列
		byte[] bs = loginacct.getBytes("ISO8859-1");
		
		// 将原始的字节码序列按照正确的编码转换为正确的文字即可。
		loginacct = new String(bs, "UTF-8");
		User dbUser = userService.query4Login(user);
		
		if ( dbUser != null ) {
			// 登陆成功，跳转到主页面
			return "main";
		} else {
			// 登陆失败，跳转回到登陆页面，提示错误信息
			String errorMsg = "登陆账号或密码不正确，请重新输入";
			model.addAttribute("errorMsg", errorMsg);
			return "redirect:login";
		}
		
		
	}
	public static void main(String[] args) {
		//测试时间比较
		String t1="2018-10-32";
		 String t2="2018-10-31 10:39:20";
		 int result = t1.compareTo(t2);
		 System.out.println(result);
		 //前一天 后一天
		 SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
         Date d=new Date();
         String predate = predf.format(new Date(d.getTime() + (long)24 * 60 * 60 * 1000));
         System.out.println(predate);
	}
}
