package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.services.UserService;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    // POST to add a user
    @PostMapping("/add/user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // GET all users
    @GetMapping("/get/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
