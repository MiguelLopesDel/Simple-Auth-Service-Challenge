package com.miguel.auth_service.controller;

import com.miguel.auth_service.domain.User;
import com.miguel.auth_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping
public class UserController {

    private final UserService service;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping("/foo-bar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> checkAuthentication() {
        return ResponseEntity.noContent().build();
    }
}
