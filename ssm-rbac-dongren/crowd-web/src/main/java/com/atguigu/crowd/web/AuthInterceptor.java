package com.atguigu.crowd.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aguigu.crowd.beam.Permission;
import com.atguigu.crowd.service.PermissionService;



public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private PermissionService permissionService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取用户的请求路径
		String uri = request.getRequestURI();
		String path = request.getSession().getServletContext().getContextPath();
		
		// 鍒ゆ柇褰撳墠璺緞鏄惁闇�瑕佽繘琛屾潈闄愰獙璇併��
		// 鏌ヨ鎵�鏈夐渶瑕侀獙璇佺殑璺緞闆嗗悎
		List<Permission> permissions = permissionService.queryAll();
		Set<String> uriSet = new HashSet<String>();
		for ( Permission permission : permissions ) {
			if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
				uriSet.add(path + permission.getUrl());
			}
		}
		
		if ( uriSet.contains(uri) ) {
			// 判断当前路径是否需要权限验证
			// 查询所有需要验证的路径集合
			Set<String> authUriSet = (Set<String>)request.getSession().getAttribute("authUriSet");
			if ( authUriSet.contains(uri) ) {
				return true;
			} else {
				response.sendRedirect(path + "/error");
				return false;
			}
		} else {
			return true;
		}
	}

}
