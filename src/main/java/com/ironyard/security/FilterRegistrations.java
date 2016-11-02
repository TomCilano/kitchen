package com.ironyard.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jasonskipper on 10/31/16.
 */
@Configuration
public class FilterRegistrations {

    @Bean
    public FilterRegistrationBean restApiFilter() {
        /**
         * Apply RestSecurityFilter filter to any request that matches /rest/*
         */
        FilterRegistrationBean registration = new FilterRegistrationBean(new RestSecurityFilter());
        registration.addUrlPatterns("/rest/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean mvcSecutiryFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new MvcSecurityFilter());
        registration.addUrlPatterns("/mvc/secure/*");
        return registration;
    }
}
