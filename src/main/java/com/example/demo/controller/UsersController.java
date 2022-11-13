package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(value = "/users")
    public ResponseEntity create(@RequestBody UserEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userService.create(user);
        return ResponseEntity.ok().body("Added new users and roles");
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(value = "/users/all")
    public ResponseEntity getAllRoles() {
        return ResponseEntity.ok(userService.getUsersAndUsersRole());
    }

    @GetMapping("/ronny")
    public String getRonny() {
        return "hy ronny";
    }
}
