package com.klfront.klblog.dataprovider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;


/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
@EnableResourceServer  // 该注解标记该服务是一个资源服务
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "res1";

    @Autowired
    TokenStore tokenStore;

    // 这里使用本地验证令牌方式
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID)//资源 id
                .tokenStore(tokenStore)  //本地验证令牌
                //.tokenServices(tokenService())//远程服务验证令牌方式
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                //.antMatchers("/**").access("#oauth2.hasScope('ROLE_ADMIN')") // 角色限制
                .antMatchers("/user/**").access("#oauth2.hasScope('ALL')") // 拥有所有角色
//                .antMatchers("/**").access("#oauth2.hasScope('ROLE_API')") // 拥有API角色
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
