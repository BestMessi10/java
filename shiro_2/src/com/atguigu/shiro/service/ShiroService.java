package com.atguigu.shiro.service;

import java.util.Date;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;

public class ShiroService {
	
	@RequiresRoles({"user"})
	public void testMethod() {
		// TODO Auto-generated method stub
			System.out.println("testMethod()"+new Date());
			//shiro的session也可以获取到httpsession
			Session session=SecurityUtils.getSubject().getSession();
			Object val=session.getAttribute("key");
			System.out.println("service session"+val);
	}
}
