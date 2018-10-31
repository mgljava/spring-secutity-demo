package com.github.mgljava.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class User {

  @Value("${cache.admin.user}")
  private String user;
  @Value("${cache.admin.password}")
  private String password;

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }
}
