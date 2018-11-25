package com.taiji.springboot.serviceImpl;

import com.taiji.springboot.service.hello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"default","dev"})
public class say implements hello {

    @Value("${age}")
    private Integer age;

    @Override
    public String hello() {
        return "年龄："+age;
    }
}
