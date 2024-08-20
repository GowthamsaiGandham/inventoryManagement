package com.project.inventorymanagementsystem.service;

import com.project.inventorymanagementsystem.repository.AdminJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminJpaService implements UserDetailsService {

    @Autowired
    AdminJpaRepository adminJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminJpaRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not Found"));
    }
}
