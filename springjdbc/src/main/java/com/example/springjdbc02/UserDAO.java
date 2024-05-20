package com.example.springjdbc02;

import org.springframework.transaction.annotation.Transactional;

public interface UserDAO {
    @Transactional
    void createAndUpdateUser(String name, String email, String newEmail);
}
