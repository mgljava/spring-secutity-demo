package com.github.mgljava.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {

    System.setProperty("name", "zhangsan");

    registry.addViewController("/").setViewName("index");
    registry.addViewController("/hello").setViewName("hello");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/world").setViewName("world");
  }
}
