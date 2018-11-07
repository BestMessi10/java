package com.atguigu.crowd.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aguigu.crowd.beam.AJAXResult;
import com.aguigu.crowd.beam.DongColumn;
import com.aguigu.crowd.beam.DongNews;
import com.aguigu.crowd.beam.DongSearch;
import com.aguigu.crowd.beam.Page;
import com.atguigu.crowd.service.DongColumnService;
import com.atguigu.crowd.service.DongNewsService;
import com.atguigu.crowd.service.UserService;

@Controller
@RequestMapping("/html")
public class IndexController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DongColumnService dongColumnService;
	@Autowired
	private DongNewsService dongNewsService;

	@RequestMapping("/index")
	public String index(Model model,Integer pageno, Integer pagesize) {
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		//1
		Map<String, Object> map = new HashMap<String, Object>();
		pageno = 1;
		pagesize =7;
		map.put("start", (pageno-1)*pagesize);
		map.put("size", pagesize);
		map.put("column", 1);
		List<DongNews> dongNewss1 = dongNewsService.pageQuery( map );
		model.addAttribute("dongNewss1", dongNewss1);
		
		//2
		Map<String, Object> map1 = new HashMap<String, Object>();
		pageno = 1;
		pagesize =5;
		map1.put("start", (pageno-1)*pagesize);
		map1.put("size", pagesize);
		map1.put("column", 2);
		List<DongNews> dongNewss2 = dongNewsService.pageQuery( map1 );
		
		String str2="";
		String[] images2 = null;
		for (DongNews dongNews2 : dongNewss2) {
			str2 = dongNews2.getContent();
			images2=getImgs(str2);
			dongNews2.setPicture(images2[0]);
		}
		model.addAttribute("dongNewss2", dongNewss2);
		
		//3
		Map<String, Object> map2 = new HashMap<String, Object>();
		pageno = 1;
		pagesize =10;
		map2.put("start", (pageno-1)*pagesize);
		map2.put("size", pagesize);
		map2.put("column", 3);
		List<DongNews> dongNewss3 = dongNewsService.pageQuery( map2 );
		
		String str="";
		String[] images = null;
		for (DongNews dongNews : dongNewss3) {
			str = dongNews.getContent();
			images=getImgs(str);
			dongNews.setPicture(images[0]);
		}
		model.addAttribute("dongNewss3", dongNewss3);
		
		//4
		Map<String, Object> map3 = new HashMap<String, Object>();
		pageno = 1;
		pagesize =10;
		map3.put("start", (pageno-1)*pagesize);
		map3.put("size", pagesize);
		map3.put("column", 4);
		List<DongNews> dongNewss4 = dongNewsService.pageQuery( map3 );
		
		String str4="";
		String[] images4 = null;
		for (DongNews dongNews : dongNewss4) {
			str4 = dongNews.getContent();
			images4=getImgs(str4);
			dongNews.setPicture(images4[0]);
		}
		model.addAttribute("dongNewss4", dongNewss4);
		
		//5
				Map<String, Object> map4 = new HashMap<String, Object>();
				pageno = 1;
				pagesize =10;
				map4.put("start", (pageno-1)*pagesize);
				map4.put("size", pagesize);
				map4.put("column",5);
				List<DongNews> dongNewss5 = dongNewsService.pageQuery( map4 );
				
				String str5="";
				String[] video = null;
				for (DongNews dongNews : dongNewss5) {
					str5 = dongNews.getContent();
					video=getVideos(str5);
					dongNews.setVideo(video[0]);;
				}
				model.addAttribute("dongNewss5", dongNewss5);
		
		//6
		Map<String, Object> map5 = new HashMap<String, Object>();
		pageno = 1;
		pagesize =10;
		map5.put("start", (pageno-1)*pagesize);
		map5.put("size", pagesize);
		map5.put("columnhot", 5);
		List<DongNews> dongNewss6 = dongNewsService.pageQuery( map5 );
		
		String str6="";
		String[] images6 = null;
		for (DongNews dongNews : dongNewss6) {
			str6 = dongNews.getContent();
			images6=getImgs(str6);
			if (images6[0] != null)
			{
				dongNews.setPicture(images6[0]);
			}
		}
		model.addAttribute("dongNewss6", dongNewss6);
		return "thymeleaf/index";
	}
	@RequestMapping("/flash")
	public String flash(Model model) {
		
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		
		List<DongSearch> dongSearchs = userService.selecthotsearch();
		model.addAttribute("dongSearchs", dongSearchs);
		return "thymeleaf/flash";
	}
	@RequestMapping("/travel")
	public String travel(Model model) {
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		
		List<DongSearch> dongSearchs = userService.selecthotsearch();
		model.addAttribute("dongSearchs", dongSearchs);
		return "thymeleaf/travel";
	}
	@RequestMapping("/economics")
	public String  economics(Model model) {
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		
		List<DongSearch> dongSearchs = userService.selecthotsearch();
		model.addAttribute("dongSearchs", dongSearchs);
		return "thymeleaf/economics"; 
	}
	@RequestMapping("/culture")
	public String culture(Model model) {
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		
		List<DongSearch> dongSearchs = userService.selecthotsearch();
		model.addAttribute("dongSearchs", dongSearchs);
		return "thymeleaf/culture"; 
	}
	@RequestMapping("/video")
	public String video(Model model) {
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		
		List<DongSearch> dongSearchs = userService.selecthotsearch();
		model.addAttribute("dongSearchs", dongSearchs);
		return "thymeleaf/video"; 
	}
	@RequestMapping("/flash_detail")
	public String flash_detail(Model model, Integer newsid) {
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		
		DongNews dongNews = dongNewsService.queryById(newsid);
		model.addAttribute("dongNews", dongNews);
		return "thymeleaf/flash_detail";
	}
	@RequestMapping("/travle_detail")
	public String travle_detail(Model model) {  
		List<DongColumn> dongColumns = dongColumnService.querycolumn();
		model.addAttribute("dongColumns", dongColumns);
		return "thymeleaf/travle_detail";
	}
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pageno, Integer pagesize,Integer column ) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			if (queryText != null) {
				
				java.util.Date dt = new java.util.Date();
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentTime = sdf.format(dt);
				
				DongSearch dongSearch = new DongSearch();
				dongSearch.setName(queryText);
				dongSearch.setTime(currentTime);
				userService.inseartSearch(dongSearch);
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			map.put("column", column);
			List<DongNews> dongNews = dongNewsService.pageQuery( map );
			if (column == 2) {
				String str="";
				String[] images = null;
				List<String> a1;
				for (DongNews dongNew : dongNews) {
					str = dongNew.getContent();
					images=getImgs(str);
					a1 =Arrays.asList(images);
					dongNew.setImgs(a1);
				}
				
			}
			if(column == 3 || column == 4 || column == 1) {
				String str="";
				String[] images = null;
				for (DongNews dongNew : dongNews) {
					str = dongNew.getContent();
					images=getImgs(str);
					dongNew.setPicture(images[0]);
				}
			}
			if (column == 5){
				String str5="";
				String[] video = null;
				for (DongNews dongNew : dongNews) {
					str5 = dongNew.getContent();
					video=getVideos(str5);
					dongNew.setVideo(video[0]);;
				}
			}
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
	/// <summary> 
    /// 取得HTML中所有图片的 URL。 
    /// </summary> 
    /// <param name="sHtmlText">HTML代码</param> 
    /// <returns>图片的URL列表</returns> 
	public static void main(String[] args) {
		String str = "<p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; color: rgb(77, 79, 83); font-family: &#39;Microsoft Yahei&#39;, &#39;\\\\5FAE软雅黑&#39;, &#39;STHeiti Light&#39;, &#39;\\\\534E文细黑&#39;, SimSun, &#39;\\\\5B8B体&#39;, Arial, sans-serif; font-size: 18px; letter-spacing: 1px; line-height: 32px; white-space: normal; background-color: rgb(255, 255, 255);\">最近网上流传的一段30秒的视频令广大军友激动万分。</p><p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; color: rgb(77, 79, 83); font-family: &#39;Microsoft Yahei&#39;, &#39;\\\\5FAE软雅黑&#39;, &#39;STHeiti Light&#39;, &#39;\\\\534E文细黑&#39;, SimSun, &#39;\\\\5B8B体&#39;, Arial, sans-serif; font-size: 18px; letter-spacing: 1px; line-height: 32px; white-space: normal; background-color: rgb(255, 255, 255);\">　　长光卫星官方微博发布了一条视频，视频当中的主角是一艘美国海军的“尼米兹”级核动力航母，此时它正在拖船的帮助下缓缓地进入圣地亚哥军港。</p><p><img src=\"http://localhost:8080/crowd-web/ueditor/jsp/upload/image/20181024/1540350388340026523.jpg\" alt=\"\"/><span class=\"img_descr\" style=\"margin: 5px auto; padding: 6px 0px; line-height: 20px; font-size: 16px; display: inline-block; zoom: 1; text-align: left; font-weight: 700;\"></span></p><p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; color: rgb(77, 79, 83); font-family: &#39;Microsoft Yahei&#39;, &#39;\\\\5FAE软雅黑&#39;, &#39;STHeiti Light&#39;, &#39;\\\\534E文细黑&#39;, SimSun, &#39;\\\\5B8B体&#39;, Arial, sans-serif; font-size: 18px; letter-spacing: 1px; line-height: 32px; white-space: normal; background-color: rgb(255, 255, 255);\">　　这段30秒的视频清晰度相当高，航母的舰岛，蒸汽弹射器轨道和甲板上的划线都看得很清楚，甚至还能看到拖船推进器搅动海水产生的白色航迹，需知道这可是从运行在500千米高的太空的“吉林一号”星载光学摄影机拍下来的，还是动态的视频，清晰度达到了4K的标准，在全球仅有中国能够做到。</p><p><img src=\"http://localhost:8080/crowd-web/ueditor/jsp/upload/image/20181024/1540350388404010854.jpg\" alt=\"\"/></p><p><br/></p>";
		String str2 ="<p><video class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://localhost:8080/crowd-web/ueditor/jsp/upload/video/20181026/1540536808348045164.mp4\" data-setup=\"{}\"></video></p><p style=\"border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; font-size: 18.018px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: rgb(25, 25, 25); font-family: &#39;PingFang SC&#39;, Arial, 微软雅黑, 宋体, simsun, sans-serif; line-height: 34.2342px; white-space: normal; background-color: rgb(255, 255, 255);\"><img src=\"http://localhost:8080/crowd-web/ueditor/jsp/upload/image/20181026/1540536818084042497.jpg\" alt=\"\"/></p><p style=\"border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; font-size: 18.018px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: rgb(25, 25, 25); font-family: &#39;PingFang SC&#39;, Arial, 微软雅黑, 宋体, simsun, sans-serif; line-height: 34.2342px; white-space: normal; background-color: rgb(255, 255, 255);\">葛优生活照</p><p style=\"border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; font-size: 18.018px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: rgb(25, 25, 25); font-family: &#39;PingFang SC&#39;, Arial, 微软雅黑, 宋体, simsun, sans-serif; line-height: 34.2342px; white-space: normal; background-color: rgb(255, 255, 255);\">最后，生活中，葛优是个风趣，与周围格格不入的人，在2006年，手机满大街的时候，记者采访他，他还老留BP机号，被人戏称葛大爷只用BP机。葛大爷害怕坐飞机，拍戏、领奖都坐火车，用他自己的话说，打死也不坐飞机，甚至有人戏称，葛大爷去戛纳领奖也是坐火车去的，倒了好多趟。</p><p style=\"border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; font-size: 18.018px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: rgb(25, 25, 25); font-family: &#39;PingFang SC&#39;, Arial, 微软雅黑, 宋体, simsun, sans-serif; line-height: 34.2342px; white-space: normal; background-color: rgb(255, 255, 255);\">和人聊天半个小时还不知道</p><p><br/></p>";
		String[] images = null;
		String[] videos = null;
		images=getImgs(str);
		videos =getVideos(str2);
		for (String video : videos) {
			System.out.println(video);
		}
		for (String img : images) {
			System.out.println(img);
		}
	}
	private static String[] getImgs(String content) {

		String img = "";
		Pattern p_image;
		Matcher m_image;
		String str = "";
		String[] images = null;
		String regEx_img = "(<img.*src\\s*=\\s*(.*?)[^>]*?>)";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(content);
		while (m_image.find()) {
		img = m_image.group();
		Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)")
		.matcher(img);
		while (m.find()) {
		String tempSelected = m.group(1);
		if ("".equals(str)) {
		str = tempSelected;
		} else {
		String temp = tempSelected;
		str = str + "," + temp;
		}
		}
		}
		if (!"".equals(str)) {
		images = str.split(",");
		}
		return images;
		}
	private static String[] getVideos(String content) {

		String img = "";
		Pattern p_image;
		Matcher m_image;
		String str = "";
		String[] images = null;
		String regEx_img = "(<video.*src\\s*=\\s*(.*?)[^>]*?>)";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(content);
		while (m_image.find()) {
		img = m_image.group();
		Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)")
		.matcher(img);
		while (m.find()) {
		String tempSelected = m.group(1);
		if ("".equals(str)) {
		str = tempSelected;
		} else {
		String temp = tempSelected;
		str = str + "," + temp;
		}
		}
		}
		if (!"".equals(str)) {
		images = str.split(",");
		}
		return images;
		}
	
}
