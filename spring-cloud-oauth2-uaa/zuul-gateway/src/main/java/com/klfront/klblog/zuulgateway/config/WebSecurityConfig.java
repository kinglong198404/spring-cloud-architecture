package com.klfront.klblog.zuulgateway.config;

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
                //.antMatchers("/sysUser/view").hasAuthority("user_view")
                //可在ResouceServerConfig中单独配置放行或其他安全策略。ResouceServerConfig中的配置优先级高。
                .antMatchers("/**").authenticated()//所有请求必须登录校验通过
                .anyRequest().permitAll()//除此之外其它的请求可以访问
        ;
    }
}
