package com.atguigu.crowd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aguigu.crowd.beam.AJAXResult;
import com.aguigu.crowd.beam.DongColumn;
import com.aguigu.crowd.beam.DongNews;
import com.aguigu.crowd.beam.Page;
import com.aguigu.crowd.beam.Role;
import com.aguigu.crowd.beam.User;
import com.atguigu.crowd.service.DongColumnService;
import com.atguigu.crowd.service.DongNewsService;

@Controller
@RequestMapping("/usernews")
public class DongNewsController2 {
	
	@Autowired
	private DongNewsService dongNewsService;
	
	@Autowired
	private DongColumnService dongColumnService;
	
	@RequestMapping("/index")
	public Object index() {
		
		return "usernews/index";
	}
	
	@RequestMapping("/add")
	public Object add(Model model) {
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		return "usernews/add";
	}
	@RequestMapping("/ueditor")
	public Object ueditor() {
		
		return "usernews/ueditor";
	}
	//审核
	@ResponseBody
	@RequestMapping("/assign")
	public Object assign(Integer id , String flag,HttpServletRequest request, HttpServletResponse response) {
		
		AJAXResult result = new AJAXResult();
		try {
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			DongNews dongNews=dongNewsService.queryById(id);
			if ("0".equals(flag)){
				dongNews.setStatus(0);
			}else {
				dongNews.setStatus(1);
			}
			dongNewsService.updateDongNews(dongNews);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(DongNews dongNews,HttpServletRequest request, HttpServletResponse response) {
		AJAXResult result = new AJAXResult();
		try {
			if (dongNews.getPublishTime() == null || "".equals(dongNews.getPublishTime()) )
			{
				java.util.Date dt = new java.util.Date();
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentTime = sdf.format(dt);
				dongNews.setPublishTime(currentTime);
			}
			dongNews.setStatus(0);
			
			 //保存当前用户id
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			dongNews.setUid(loginUser.getId());
			//dongNews.setRole(3);
			dongNewsService.insert(dongNews);
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete( Integer id ) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			dongNewsService.deleteDongNewsById(id);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes( Integer[] dongNewsid ) {
		AJAXResult result = new AJAXResult();
		
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dongNewsids", dongNewsid);
			dongNewsService.deletedongNewss(map);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/edit")
	public String edit( Integer id, Model model ) {
		
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		
		DongNews dongNews = dongNewsService.queryById(id);
		model.addAttribute("dongNews", dongNews);
		
		return "usernews/edit";
	}
	@ResponseBody
	@RequestMapping("/update")
	public Object update(DongNews dongNews) {
		AJAXResult result = new AJAXResult();
		
		try {
		
			dongNewsService.updateDongNews(dongNews);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pageno, Integer pagesize,HttpServletRequest request, HttpServletResponse response ) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			map.put("columnId", 4);
			
			//传入用户id
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			map.put("uid", loginUser.getId());
			List<DongNews> dongNews = dongNewsService.pageQuery( map );
			
			int totalsize = dongNewsService.pageQueryCount( map );
			
			int totalno = 0;
			if ( totalsize % pagesize == 0 ) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
		
			Page<DongNews> userPage = new Page<DongNews>();
			userPage.setDatas(dongNews);
			userPage.setTotalno(totalno);
			userPage.setTotalsize(totalsize);
			userPage.setPageno(pageno);
			
			result.setData(userPage);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
	}
	
	
	@ResponseBody
	@RequestMapping("/queryAll")
	public Object queryAll() {
		DongNews dongNews =  dongNewsService.queryAll();
		return dongNews;
	}
}
