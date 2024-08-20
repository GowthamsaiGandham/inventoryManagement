package com.project.inventorymanagementsystem.controller;

import com.project.inventorymanagementsystem.model.Supplier;
import com.project.inventorymanagementsystem.repository.SupplierJpaRepository;
import com.project.inventorymanagementsystem.service.SupplierJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SupplierController {
    @Autowired
    SupplierJpaService supplierJpaService;

    @GetMapping("/suppliers")
    public ArrayList<Supplier> getSuppliers(){
        return supplierJpaService.getSuppliers();
    }

    @PostMapping("/suppliers")
    public Supplier addSupplier(@RequestBody Supplier newSupplier){
        return supplierJpaService.addSupplier(newSupplier);
    }

    @GetMapping("/suppliers/{supplierId}")
    public Supplier getSupplierById(@PathVariable("supplierId") int supplierId){
        return supplierJpaService.getSupplierById(supplierId);
    }

    @PutMapping("/suppliers/{supplierId}")
    public Supplier updateSupplier(@PathVariable("supplierId") int supplierId,@RequestBody Supplier updateDetails){
        return supplierJpaService.updateSupplier(supplierId,updateDetails);
    }

    @DeleteMapping("/suppliers/{supplierId}")
    public void deleteSupplier(@PathVariable("supplierId") int supplierId){
        supplierJpaService.deleteSupplier(supplierId);
    }
}
