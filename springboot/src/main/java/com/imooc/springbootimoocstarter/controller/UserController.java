package com.imooc.springbootimoocstarter.controller;

import com.imooc.springbootimoocstarter.pojo.IMoocJSONResult;
import com.imooc.springbootimoocstarter.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController  //rescontroller=controller+responsebody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){
        User user=new User();
        user.setName("imooc");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("imooc");
        user.setDesc("as");
        return user;
    }

    @RequestMapping("/getUserJson")
    @ResponseBody
    public IMoocJSONResult getUserJson(){
        User user=new User();
        user.setName("imooc");
        user.setAge(1800);
        user.setBirthday(new Date());
        user.setPassword("imooc");
        user.setDesc("asaasdasdas");
        return IMoocJSONResult.ok(user);
    }
}
