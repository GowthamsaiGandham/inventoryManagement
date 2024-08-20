package com.project.inventorymanagementsystem.repository;

import com.project.inventorymanagementsystem.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierJpaRepository extends JpaRepository<Supplier,Integer> {
}
