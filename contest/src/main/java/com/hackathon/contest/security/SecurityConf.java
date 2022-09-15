package com.hackathon.contest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .anyRequest()
            .permitAll()
            .and()
            .csrf()
            .disable()
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and()
            .cors()
            .disable()
            .httpBasic();
  }
}