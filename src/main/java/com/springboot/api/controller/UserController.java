package com.springboot.api.controller;

import com.springboot.api.dao.UserDao;
import com.springboot.api.domain.User;
import com.springboot.api.domain.dto.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao= userDao;
    }

    @GetMapping("/user")
    public User addAndGet() throws SQLException {
        return userDao.get("1");
    }
    @PostMapping("/user")
    public String postMemberDto(@RequestBody User user) {
        return user.toString();
    }
    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
