package com.springboot.api.controller;

import com.springboot.api.dao.UserDao;
import com.springboot.api.domain.User;
import com.springboot.api.domain.dto.MemberDto;
import com.springboot.api.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao= userDao;
    }

    @PostMapping("")
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getId(),userRequestDto.getName(),userRequestDto.getPassword());
        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }
    @DeleteMapping("")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .body(userDao.get(id));
    }
}
