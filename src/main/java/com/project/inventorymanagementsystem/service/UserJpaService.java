package com.project.inventorymanagementsystem.service;

import com.project.inventorymanagementsystem.model.User;
import com.project.inventorymanagementsystem.repository.UserJpaRepository;
import com.project.inventorymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserJpaService implements UserRepository {
    @Autowired
    UserJpaRepository userJpaRepository;

    @Override
    public ArrayList<User> getUsers(){
        List<User>  usersList = userJpaRepository.findAll();
        return new ArrayList<>(usersList);
    }

    @Override
    public User addUser(User newUser) {
        userJpaRepository.save(newUser);
        return newUser;
    }

    @Override
    public User getUserById(int userId) {
        try{
            return userJpaRepository.findById(userId).get();
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not Found");
        }
    }

    @Override
    public User updateUserDetails(int userId, User userDetails) {
        try{
            User existingUser = getUserById(userId);
            if(userDetails.getUserName() != null){
                existingUser.setUserName(userDetails.getUserName());
            }
            if(userDetails.getEmail() != null){
                existingUser.setUserName(userDetails.getEmail());
            }
            if(userDetails.getImageUrl() != null){
                existingUser.setImageUrl(userDetails.getImageUrl());
            }
            if(userDetails.getDeliveryAddress() != null){
                existingUser.setDeliveryAddress(userDetails.getDeliveryAddress());
            }
            return existingUser;
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not Found");
        }
    }

    @Override
    public void deleteUser(int userId) {
        try{
            getUserById(userId);
            userJpaRepository.deleteById(userId);
            throw new  ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not Found");
        }
    }
}


//@Override
//public ResponseEntity<String> deleteCustomer(Integer id) {
//    Optional<Customer> customer = customerJpaRepository.findById(id);
//    if(customer.isPresent()){
//        feedbackJpaRepository.deleteByCustomerId(id);
//        customerJpaRepository.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }else{
//        return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
//    }
//
//}



//@Override
//public ResponseEntity<Object> getCustomerById(Integer id) {
//    Optional<Customer> customer = customerJpaRepository.findById(id);
//
//    if(customer.isEmpty()){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("customer not found.");
//    }
//
//    return ResponseEntity.ok(customer.get());
//}