package com.example.jdbc02.dao;

import com.example.jdbc02.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor // final이 붙어있는 필드에 대해서 생성자를 생성해줌
@Repository
public class UserDAOImpl implements UserDAO {

    // JdbcTemplate 객체 이요해서 구현 할거니까..
    // 필드 기반
    //@Autowired
    private final JdbcTemplate jdbcTemplate;

    /*
    // 생성자 기반
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 설정자 기반
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
     */

    @Override
    public void insertUser(User user) {
        try {
            String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
            jdbcTemplate.update(sql, user.getName(), user.getEmail());
        } catch (DataAccessException e) {
            throw new DataAccessException("Error inserting user " + user.getName(), e) {
            };
        }
    }

    @Override
    public List<User> findAllUsers() {
        try {
            String sql = "SELECT * FROM users";

        /*
        RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("email")
        );

        return jdbcTemplate.query(sql, rowMapper);
         */

            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

            return users;
        } catch (DataAccessException e) {
            throw new DataAccessException("Error retrieving users", e) {
            };
        }
    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql = "UPDATE users SET email = ? WHERE name = ?";
        int updated = jdbcTemplate.update(sql, email, name);
        if (updated == 0) {
            throw new UserNotFoundException("No user found with name: " + name);
        }

        // 업데이트된 정보만 출력
        System.out.println("Updated user information for " + name + ": ");
        System.out.println("- Email: " + email);
    }

    @Override
    public void deleteUser(String name) {
        String sql = "DELETE FROM users WHERE name = ?";
        int deleted = jdbcTemplate.update(sql, name);
        if (deleted == 0) {
            throw new UserNotFoundException("No user found with name: " + name);
        }

        // 삭제된 정보만 출력
        System.out.println("Deleted user for name : " + name);
    }
}