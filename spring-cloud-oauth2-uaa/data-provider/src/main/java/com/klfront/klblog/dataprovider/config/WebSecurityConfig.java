package com.klfront.klblog.dataprovider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/r/r1").hasAuthority("p1")// /r/r1的请求必须拥有p1权限
//                .antMatchers("/r/r2").hasAuthority("p2")// /r/r2的请求必须拥有p2权限
//                .antMatchers("/knowledgeBase/**").authenticated()//所有/knowledgeBase/**的请求必须认证通过
                .anyRequest().permitAll()//除此之外其它的请求可以访问
        ;
    }
}
