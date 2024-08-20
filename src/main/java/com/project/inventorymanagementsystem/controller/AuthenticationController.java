package com.project.inventorymanagementsystem.controller;


import com.project.inventorymanagementsystem.model.Admin;
import com.project.inventorymanagementsystem.model.AuthenticationResponse;
import com.project.inventorymanagementsystem.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Admin request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Admin request){
        System.out.println("Excecuting");
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
