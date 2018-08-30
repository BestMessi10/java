package com.imooc.springbootimoocstarter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
//扫描mybatis mapper包路径
@MapperScan(basePackages = "com.imooc.springbootimoocstarter.mapper")
//扫描所有需要的包，包含一些自用的工具类
@ComponentScan(basePackages= {"com.imooc.springbootimoocstarter", "org.n3r.idworker"})
//开启定时任务
@EnableScheduling
public class SpringbootImoocStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootImoocStarterApplication.class, args);
    }
}
