package com.example.jdbc02;

import com.example.jdbc02.dao.Dept;
import com.example.jdbc02.dao.DeptDAO;
import com.example.jdbc02.dao.User;
import com.example.jdbc02.dao.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJDBC02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC02Application.class, args);
    }

    @Bean
    public CommandLineRunner user(UserDAO userDAO) {
        return args -> {
            // INSERT TEST
            userDAO.insertUser(new User(null, "hyoseung", "dev.hyoseung@gamil.com"));
            userDAO.insertUser(new User(null, "ubin", "ubin@gamil.com"));

            // READ TEST
            List<User> users = userDAO.findAllUsers();
            users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));

            // UPDATE TEST
            userDAO.updateUserEmail("ubin", "ubin@naver.com");

            // DELETE TEST
            //userDAO.deleteUser("ubin");
        };
    }

    @Bean
    public CommandLineRunner dept(DeptDAO deptDAO) {
        return (args) -> {
            // READ TEST
            List<Dept> depts = deptDAO.getDepts();
            depts.forEach(dept -> System.out.println(dept.getName() + " - " + dept.getLocation()));
        };
    }
}