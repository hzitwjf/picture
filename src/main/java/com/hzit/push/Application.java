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
     /**
     * MultipartConfigElement 这个类构建与所有位置默认的实例。
     * MultipartConfigFactory类是Spring提供的所有的用于上传文件的类，可以规定其尺寸的值可以使用传统的长值的困扰或使用更具可读性,接受KB或MB的后缀
     * setMaxFileSize("1024KB") 工厂设置文件的最大尺寸1024KB
     * setMaxRequestSize("1024KB")工厂设置文件的每次接收最大尺寸1024KB
     * createMultipartConfig 创建一个新的MultipartConfigElement实例。
     */
        MultipartConfigFactory multipartConfigFactory=new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize("1024KB");
        multipartConfigFactory.setMaxRequestSize("1024KB");
        return multipartConfigFactory.createMultipartConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
