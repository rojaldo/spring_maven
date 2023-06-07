package com.example.demo.library.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UsersRestController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserDto>> getUsers() {
        return ResponseEntity.status(200).body(this.usersService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody @Validated UserDto user) {
        return ResponseEntity.status(201).body(this.usersService.createUser(user));
    }
    
}
