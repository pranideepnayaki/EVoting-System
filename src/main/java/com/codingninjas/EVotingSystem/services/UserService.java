package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Add a new user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Get a user by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    // Get a user by name (for login or registration purposes)
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
}

