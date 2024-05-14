package com.example.iocexam.config;

import com.example.iocexam.controller.UserController;
import com.example.iocexam.dao.UserDao;
import com.example.iocexam.dao.UserDaoImpl;
import com.example.iocexam.service.UserService;
import com.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.iocexam")
public class UserConfig {
    /*
    // IOC 컨테이너에 Bean을 동락하는 방법을 생각해보고 동작 할 수 있도록 작성해주세요.
    // 1. JavaConfig를 이용해서 동작하도록!!
    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }

    @Bean
    public UserService userService(UserDao userDao){
        return new UserServiceImpl(userDao);
    }

    @Bean
    public UserController userController(UserServiceImpl userService){
        return new UserController(userService);
    }

    // 2. component scan 동작되도록 살펴보세요..
     */
}