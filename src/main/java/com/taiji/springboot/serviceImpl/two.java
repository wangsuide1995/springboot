package com.taiji.springboot.serviceImpl;

import com.taiji.springboot.service.hello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"hello"})
public class two implements hello {

    @Value("${name}")
    private String name;

    @Override
    public String hello() {
        return "姓名："+name;
    }
}
