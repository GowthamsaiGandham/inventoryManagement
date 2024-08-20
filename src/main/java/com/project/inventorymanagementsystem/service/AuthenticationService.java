package com.project.inventorymanagementsystem.service;


import com.project.inventorymanagementsystem.model.Admin;
import com.project.inventorymanagementsystem.model.AuthenticationResponse;
import com.project.inventorymanagementsystem.repository.AdminJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    AdminJpaRepository adminJpaRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;


    public AuthenticationResponse register(Admin request){
        Admin admin = new Admin();
        admin.setAdminName(request.getAdminName());
        admin.setUsername(request.getUsername());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setRole(request.getRole());

        admin = adminJpaRepository.save(admin);
        String token = jwtService.generateToken(admin);
        return new AuthenticationResponse(token);
    }


    public AuthenticationResponse authenticate(Admin request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        Admin admin = adminJpaRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(admin);
        return new AuthenticationResponse(token);
    }
}
