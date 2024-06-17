package com.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index"); // Maps the root URL to index.html
        registry.addViewController("/index").setViewName("index"); // Maps /index to index.html
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/chat-websocket")
                .allowedOrigins("https://*.example.com")
                .allowedMethods("GET", "POST")
                .allowCredentials(true);
    }
}
