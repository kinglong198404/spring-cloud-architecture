package com.klfront.klblog.zuulgateway.config;

import com.klfront.klblog.zuulgateway.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 过滤器配置
 *
 * @author:lujinlong
 * @created:2024-08-04 12:03
 **/
@Configuration
public class ZuulFilterConfig {
    /**
     * 鉴权过滤器注入
     * @Author kinglong
     * @Date 2024-08-04 12:37
     * @Return com.klfront.klblog.zuulgateway.filter.AuthFilter
     */
    @Bean
    public AuthFilter preFileter() {
        return new AuthFilter();
    }

    /**
     * 跨域过滤器注入
     * @Author kinglong
     * @Date 2024-08-04 12:38

     * @Return org.springframework.boot.web.servlet.FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(18000L);
        source.registerCorsConfiguration("/**", config);
        CorsFilter corsFilter = new CorsFilter(source);
        FilterRegistrationBean bean = new FilterRegistrationBean(corsFilter);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
