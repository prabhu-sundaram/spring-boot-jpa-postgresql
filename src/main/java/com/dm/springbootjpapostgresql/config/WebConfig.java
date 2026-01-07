package com.dm.springbootjpapostgresql.config;

import com.dm.springbootjpapostgresql.interceptor.CountryInterceptor;
import com.dm.springbootjpapostgresql.interceptor.RequestInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final RequestInterceptor requestInterceptor;
    private final CountryInterceptor countryInterceptor;

    public WebConfig(RequestInterceptor requestInterceptor,
                     CountryInterceptor countryInterceptor) {
        this.requestInterceptor = requestInterceptor;
        this.countryInterceptor = countryInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(requestInterceptor)
                .addPathPatterns("/api/**");

        registry.addInterceptor(countryInterceptor)
                .addPathPatterns("/api/countries/**");
    }
}


