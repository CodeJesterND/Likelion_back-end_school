package com.example.constructorexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConstructorApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConstructorApplication.class, args);

    }
}
