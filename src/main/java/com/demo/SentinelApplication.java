package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SentinelApplication.class);
        app.run(args);
    }
}
