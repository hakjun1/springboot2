package com.springboot.api.dao;

import com.springboot.api.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user) {
        this.jdbcTemplate.update("INSERT INTO users(id,name,password) values(?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }
    public int deleteAll() {
        return this.jdbcTemplate.update("delete from users");
    }
}
