package com.taiji.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import java.util.Arrays;

@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        System.out.println("This service start...");
        SpringApplication.run(SpringbootApplication.class, args);
        System.out.println("This service stop...");
    }

    //检测bean的数量和名称
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){

        return args ->{
            System.out.println("加载的bean数量:"+ctx.getBeanDefinitionCount());
            String[] beanNames =ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for(String beanName : beanNames){
                System.out.println("加载的bean:"+beanName);
            }
        };
    }

    //拦截“hello”请求后加入处理方法
    @Bean
    public ApplicationListener<ApplicationEvent> helloLister(){
        final String HELLO_URL = "/hello";
        return (ApplicationEvent event) ->{
            ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
                if (e.getRequestUrl().equals(HELLO_URL)){
                    System.out.println("visvit hello");
                }
        };
    }

    //设定监听
    @Bean
    public static CommandLineRunner testA(){
        CommandLineRunner runner = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("This testA runner start to init...");
            }
        };
        return runner;
    }
}
