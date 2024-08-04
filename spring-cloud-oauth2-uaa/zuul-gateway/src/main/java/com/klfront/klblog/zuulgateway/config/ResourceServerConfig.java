package com.klfront.klblog.zuulgateway.config;

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
public class ResourceServerConfig {
    // 在oauth_client_details的resource_ids中需包含这个RESOURCE_ID，才有权限访问
    public static final String RESOURCE_ID = "gateway";

    // 生产者资源服务配置
    @Configuration
    @EnableResourceServer
    public class DataProviderServerConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources){
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    // 文件上传业务放行
                    .antMatchers("/file/**").permitAll()
                    // 其他需要验证
                    .antMatchers("/**").authenticated();;
        }
    }

    // Data消费者资源服务配置
    @Configuration
    @EnableResourceServer
    public class DataConsumerServerConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources){
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    // 用户接口需要ROLE_USER角色
                    .antMatchers("/data-consumer/sysUser/**").access("#oauth2.hasScope('ROLE_USER')")
                    // 文件上传业务放行
                    .antMatchers("/file/**").permitAll()
                    // 其他需要验证（这行一定要有，否则权限限制失效）
                    .antMatchers("/**").authenticated();
        }
    }
    //配置其它的资源服务.....
}
