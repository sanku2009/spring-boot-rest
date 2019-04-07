package com.javacodegeeks.example;

import com.javacodegeeks.example.interceptor.JCGRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootApp {

    private final Logger LOG = LoggerFactory.getLogger(getClass().getName());

    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }

    @Bean
    public JCGRequestInterceptor requestInterceptor() {
        return new JCGRequestInterceptor();
    }
}
