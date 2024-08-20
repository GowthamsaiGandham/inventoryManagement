package com.project.inventorymanagementsystem.repository;

import com.project.inventorymanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {
}
