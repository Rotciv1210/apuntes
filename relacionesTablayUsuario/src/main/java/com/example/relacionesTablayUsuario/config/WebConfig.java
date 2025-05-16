package com.example.relacionesTablayUsuario.config;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.SessionTrackingMode;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class WebConfig {


    @Bean
    public ServletContextInitializer servletContextInitializer(){

        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                //esto crea una cookie de una web
                servletContext.setSessionTrackingModes(
                        Collections.singleton(SessionTrackingMode.COOKIE)
                );
            }
        };
    }
}
