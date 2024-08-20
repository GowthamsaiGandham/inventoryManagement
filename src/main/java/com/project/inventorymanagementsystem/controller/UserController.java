package com.project.inventorymanagementsystem.controller;

import com.project.inventorymanagementsystem.model.User;
import com.project.inventorymanagementsystem.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    UserJpaService userJpaService;

    @GetMapping("/users")
    public ArrayList<User> getUsers(){
        return userJpaService.getUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User newUser){
        return userJpaService.addUser(newUser);
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userJpaService.getUserById(userId);
    }

    @PutMapping("/users/{userId}")
    public User updateUserDetails(@PathVariable("userId") int userId,@RequestBody User userDetails){
        return userJpaService.updateUserDetails(userId,userDetails);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") int userId){
        userJpaService.deleteUser(userId);
    }
}
