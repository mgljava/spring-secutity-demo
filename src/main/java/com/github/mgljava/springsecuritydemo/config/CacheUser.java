package com.github.mgljava.springsecuritydemo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@Configuration
@ConfigurationProperties
public class CacheUser {

  @Value("${cache.admin.user}")
  private String user;
  @Value("${cache.admin.password}")
  private String password;
}
