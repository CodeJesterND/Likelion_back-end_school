package com.example.jdbc02.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class DeptDAO {
    private final JdbcTemplate jdbcTemplate;
    public List<Dept> getDepts(){
        RowMapper<Dept> rowMapper = new DeptRowMapper();

        return  jdbcTemplate.query("SELECT deptno, dname, loc FROM dept", rowMapper);
    }
}