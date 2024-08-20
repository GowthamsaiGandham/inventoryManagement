package com.project.inventorymanagementsystem.repository;

import com.project.inventorymanagementsystem.model.User;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> getUsers();

    User addUser(User newUser);

    User getUserById(int userId);

    User updateUserDetails(int userId, User userDetails);

    void deleteUser(int userId);
}
