package com.taiji.springboot.controller;

import com.taiji.springboot.pojo.user;
import com.taiji.springboot.service.hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {

    @Autowired
    private user con;
    //注入接口，通过配置文件来指定执行的实现类
    @Autowired
    private hello hellos;

    @RequestMapping("/hello")
    public String hellos(){
        return "hello 登录者："+con.getName()+";年龄为："+con.getAge();
    }

    @RequestMapping("/say")
    public String say(){
        return hellos.hello();
    }
}
