package com.springboot.api.controller;

import com.springboot.api.dao.UserDao;
import com.springboot.api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao= userDao;
    }

    @GetMapping("/user")
    public User addAndGet() throws SQLException {
        userDao.add(new User("1", "hakjun", "1234"));
        return userDao.get("1");
    }
    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
