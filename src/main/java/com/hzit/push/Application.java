package com.hzit.push;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;

/**
 * Created by wjf13 on 2016/10/30.
 */
@SpringBootApplication
@ComponentScan({"com.hzit"})
public class Application extends SpringBootServletInitializer {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory=new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize("1024KB");
        multipartConfigFactory.setMaxRequestSize("1024KB");
        return multipartConfigFactory.createMultipartConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
