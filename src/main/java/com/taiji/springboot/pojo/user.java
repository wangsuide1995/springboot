package com.taiji.springboot.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "mys")
@Configuration
@PropertySource(value = "classpath:test.properties")
@Data
@ToString
public class user {
    private String name;
    private int age;
}
