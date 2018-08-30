package com.imooc.springbootimoocstarter.controller;

import com.imooc.springbootimoocstarter.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ftl")
public class FreemarkerController {
    @Autowired
    private Resource resource;

    @RequestMapping("index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("resource",resource);
        //不用写后缀，项目后缀已经配置了

        return "freemarker/index";
    }
    @RequestMapping("center")
    public  String center(){
        return "freemarker/center/center";
    }
}
