package com.klfront.klblog.dataconsumer.config;

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
                // 本项目已无法校验登录、角色校验、权限校验，因为过滤器执行后才能拿到用户身份信息。但是gateway已经做过校验，因此这里直接放行。只需在控制器中进行方法级别的权限校验即可。
//                .antMatchers("/**").authenticated()
//                .antMatchers("/sysUser/view").access("hasAuthority('user_view')")
//                .antMatchers("/sysUser/view").access("hasRole('ROLE_USER')")
                .anyRequest().permitAll()//除此之外其它的请求可以访问
        ;
    }
}
