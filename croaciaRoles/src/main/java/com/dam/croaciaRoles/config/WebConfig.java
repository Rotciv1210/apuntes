package com.dam.croaciaRoles.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.SessionTrackingMode;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Component
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ServletContextInitializer servletContextInitializer(){

        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setSessionTrackingModes(
                        Collections.singleton(SessionTrackingMode.COOKIE)
                );
            }
        };
    }

}
