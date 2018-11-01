package com.github.mgljava.springsecuritydemo.secutity;

import com.github.mgljava.springsecuritydemo.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private MyUser myUser;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/", "/hello").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .permitAll();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsServiceBean() {
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    final UserDetails user = User.withUsername(myUser.getUser())
        .password(encoder.encode(myUser.getPassword()))
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
  }
}
