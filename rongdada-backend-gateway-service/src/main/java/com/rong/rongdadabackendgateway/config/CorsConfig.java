package com.rong.rongdadabackendgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Arrays;

/**
 * 全局跨域配置
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 允许发送 Cookie
        config.setAllowCredentials(true);
        // 放行哪些域名（必须用 patterns，否则 * 会和 allowCredentials 冲突）
        config.addAllowedOriginPattern("*");
        // 允许所有请求方法
        config.addAllowedMethod("*");
        // 允许所有请求头
        config.addAllowedHeader("*");
        // 暴露的响应头
        config.addExposedHeader("*");
        // 预检请求的有效期（秒）
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有路径应用跨域配置
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}

