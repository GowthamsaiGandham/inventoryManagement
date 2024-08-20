package com.project.inventorymanagementsystem.repository;


import com.project.inventorymanagementsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminJpaRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUsername(String username);
}
