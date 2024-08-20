package com.project.inventorymanagementsystem.repository;

import com.project.inventorymanagementsystem.model.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductJpaRepository extends JpaRepository<UserProduct,Integer> {
}
