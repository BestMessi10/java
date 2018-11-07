package com.atguigu.crowd.controller;

import java.rmi.server.ExportException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aguigu.crowd.beam.DongLog;
import com.atguigu.crowd.service.UserService;
import com.atguigu.crowd.util.ExportExcel;

@Controller
@RequestMapping("/export")
public class ExportController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public Object index() {
		
		return "export/index";
	}
	@RequestMapping("/download")
	public void index(HttpServletRequest request, HttpServletResponse response) {
		 String title = "登陆注册日志导出";
			 SimpleDateFormat predf = new SimpleDateFormat("yyyy-MM-dd");
	         Date d=new Date();
	         String endDate = predf.format(new Date(d.getTime() + (long)24 * 60 * 60 * 1000));
	         String startDate = predf.format(new Date(d.getTime()));
		       
		 	Map<String, Object> map = new HashMap<String, Object>();
		 	map.put("startDate", startDate);
			map.put("endDate", endDate);
			
		 	List<DongLog>  dongLogs = userService.selectOneDay(map);
		 	
	        String[] columnName = new String[]{"序号","类型","username","账号","时间"};
	        List<Object[]> dataList1 = new ArrayList<Object[]>();
	        Object[] objs1;
	        int i = 0;
	        for (DongLog dongLog : dongLogs) {
	        	objs1 = new Object[columnName.length];
	        	objs1[0] = i;
	            objs1[1] = dongLog.getType() == 0?"注册":"登录";
	            objs1[2] = dongLog.getUsername();
	            objs1[3] = dongLog.getLoginacct();
	            objs1[4] = dongLog.getTime();
	            i++;
	            dataList1.add(objs1);	
			}
	        /*List<Object[]> dataList = new ArrayList<Object[]>();
	        Object[] objs;
	        for (int i = 0; i <2; i++) {
	            objs = new Object[columnName.length];
	            objs[0] = i;
	            objs[1] = "1";
	            objs[2] = "2";
	            dataList.add(objs);
	        }*/
	        //实例化工具类
	        ExportExcel ex = new ExportExcel(title, columnName, dataList1,request,response);
	        try {
	            //导出excel
	            ex.export();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

