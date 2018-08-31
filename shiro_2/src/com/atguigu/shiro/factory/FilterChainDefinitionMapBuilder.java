package com.atguigu.shiro.factory;

import java.util.LinkedHashMap;

//FilterChainDefinitionsMapBuilder
public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		
		LinkedHashMap<String, String> map=new LinkedHashMap<>();
		/**
		 * /login.jsp= anon
		                /shiro/shiroLogin = anon
		                /shiro/logout=logout
		                
		                �ڵ�½���Ժ�������Ȩ�޾Ϳ��Է�����
		               	/admin.jsp=roles[admin]
		                /user.jsp=roles[user] 
		              
		                
		                # everything else requires authentication:
		                /** = authc
		 * **/
		
		map.put("/login.jsp", "anon");
		map.put("/shiro/shiroLogin", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/user.jsp", "authc,roles[user]");
		map.put("/admin.jsp", "authc,roles[admin]");
		
		map.put("/**", "authc");
		return map;
		
	}
}
