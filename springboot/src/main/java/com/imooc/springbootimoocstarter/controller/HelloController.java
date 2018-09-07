package com.imooc.springbootimoocstarter.controller;

import com.imooc.springbootimoocstarter.pojo.IMoocJSONResult;
import com.imooc.springbootimoocstarter.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/re")
public class HelloController {

    @Autowired
    private Resource resource;
    @RequestMapping("/hello")
    public Object hello(){
        return "123123123123";
    }

    @RequestMapping("/getResource")
    public IMoocJSONResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return IMoocJSONResult.ok(bean);
    }
}
//