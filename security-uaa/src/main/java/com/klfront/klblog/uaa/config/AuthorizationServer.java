package com.klfront.klblog.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0
 * 授权服务配置
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    //TokenConfig中
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    //WebSecurityConfig中
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 客户端详情服务
     * ClientDetailsService负责查找ClientDetails，而ClientDetails有几个重要的属性如下列表：
     * clientId：（必须的）用来标识客户的Id。
     * secret：（需要值得信任的客户端）客户端安全码，如果有的话。
     * scope：用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围。
     * authorizedGrantTypes：此客户端可以使用的授权类型，默认为空。
     * authorities：此客户端可以使用的权限（基于Spring Security authorities）
     **/
    @Autowired
    private ClientDetailsService clientDetailsService;

    /* 客户端详情服务
     * 从数据库查询
     */
    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService) clientDetailsService).setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

    //授权码服务
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        //return new InMemoryAuthorizationCodeServices(); 内存方式
        return new JdbcAuthorizationCodeServices(dataSource);//设置授权码模式的授权码如何存取
    }

    //令牌管理服务
    @Bean
    public AuthorizationServerTokenServices tokenService() {
        DefaultTokenServices service=new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService);//客户端详情服务
        service.setSupportRefreshToken(true);//支持刷新令牌
        service.setTokenStore(tokenStore);//令牌存储策略
        //令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);
        service.setAccessTokenValiditySeconds(7200); // 令牌默认有效期2小时
        service.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3天
        return service;
    }

    //1.客户端详情服务配置（处理哪些客户端，校验客户端合法性，合法再颁发令牌。）
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
           /* clients.inMemory()// 使用in-memory存储
            .withClient("c1")// client_id
            .secret(new BCryptPasswordEncoder().encode("secret"))//客户端密钥
            .resourceIds("res1")//资源列表
            .authorizedGrantTypes("authorization_code", "password","client_credentials","implicit","refresh_token")// 该client允许的授权类型authorization_code,password,refresh_token,implicit,client_credentials
            .scopes("all")// 允许的授权范围
            .autoApprove(false)//false跳转到授权页面
            //加上验证回调地址
            .redirectUris("http://www.baidu.com");
            .and()
            .withClient("c2")
            ....
            */
        clients.withClientDetails(clientDetailsService);
    }

    //2.令牌访问端点配置（申请令牌的访问端点即Url和令牌服务，token怎么存取）
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(authenticationManager)//认证管理器
                .authorizationCodeServices(authorizationCodeServices)//授权码服务
                .tokenServices(tokenService())//令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    //3.令牌访问安全策略配置（什么样的安全策略）

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security){
        security
                .tokenKeyAccess("permitAll()")                    //oauth/token_key是公开
                .checkTokenAccess("permitAll()")                  //oauth/check_token公开
                .allowFormAuthenticationForClients()				//表单认证（申请令牌）
        ;
    }

}
