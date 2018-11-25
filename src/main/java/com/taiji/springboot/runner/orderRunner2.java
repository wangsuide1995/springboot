package com.taiji.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//利用order注解来控制执行的类的顺序
@Component
@Order(2)
public class orderRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("This runnerOrder2 start...");
    }
}
