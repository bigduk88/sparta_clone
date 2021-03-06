package com.sparta.sparta_clone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override       //CORS POLICY 관련 설정
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry
                .addMapping("/api/**")
                .allowedOrigins("**")
                .allowedMethods(
                    HttpMethod.GET.name(),
                    HttpMethod.HEAD.name(),
                    HttpMethod.POST.name(),
                    HttpMethod.PUT.name(),
                    HttpMethod.DELETE.name());
    }
}
