package com.example.iocexam.dao;

import com.example.iocexam.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserHyoseungDaoImpl implements UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+" 의 정보가 잘 저장 되었습니다.");
    }
}