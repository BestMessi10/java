package com.atguigu.shiro.handlers;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.shiro.service.ShiroService;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {
	
	@Autowired
	private ShiroService shiroService;
	
	@RequestMapping("/shiroAnnotation")
	public String shiroAnnotation(HttpSession session) {
		// TODO Auto-generated method stub
		
			session.setAttribute("key", "value12345");
			shiroService.testMethod();
			return "redirect:/list.jsp";
	}
	@RequestMapping("/shiroLogin")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		Subject currentUser = SecurityUtils.getSubject();
		  if (!currentUser.isAuthenticated()) {
	        	//���û��������װ�ɶ���
	            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	            System.out.println("1."+token.hashCode());
	            //��ס
	            token.setRememberMe(true);
	            try {
	            	//ִ�е�½��*****�ⲽ�����realm
	                currentUser.login(token);
	                //Ҫ��û�˻����׳��쳣
	            }
	            // ... catch more exceptions here (maybe custom ones specific to your application?
	            //��֤�쳣�ĸ���  ����������
	            catch (AuthenticationException ae) {
	                //unexpected condition?  error?
	            	System.out.println("��½ʧ��"+ae.getMessage());
	            }
	        }

		
		return "redirect:/list.jsp";
		
	}
}
