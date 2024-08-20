package com.project.inventorymanagementsystem.service;


import com.project.inventorymanagementsystem.model.Supplier;
import com.project.inventorymanagementsystem.repository.SupplierJpaRepository;
import com.project.inventorymanagementsystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SupplierJpaService implements SupplierRepository {
    @Autowired
    SupplierJpaRepository supplierJpaRepository;

    @Override
    public ArrayList<Supplier> getSuppliers(){
        List<Supplier> suppliersList = supplierJpaRepository.findAll();
        return new ArrayList<>(suppliersList);
    }

    @Override
    public Supplier addSupplier(Supplier newSupplier) {
        supplierJpaRepository.save(newSupplier);
        return newSupplier;
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        try{
            return supplierJpaRepository.findById(supplierId).get();
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier Not Found");
        }
    }

    @Override
    public Supplier updateSupplier(int supplierId, Supplier updateDetails) {
        try{
            Supplier existingSupplier = supplierJpaRepository.findById(supplierId).get();
            if(updateDetails.getSupplierName() != null){
                existingSupplier.setSupplierName(updateDetails.getSupplierName());
            }
            if(updateDetails.getMobileNum() != null){
                existingSupplier.setMobileNum(updateDetails.getMobileNum());
            }
            if(updateDetails.getAddress() != null){
                existingSupplier.setAddress(updateDetails.getAddress());
            }
            if(updateDetails.getActive() != null){
                existingSupplier.setActive(updateDetails.getActive());
            }
            return existingSupplier;
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier Not Found");
        }
    }

    public void deleteSupplier(int supplierId) {
        try{
            getSupplierById(supplierId);
            supplierJpaRepository.deleteById(supplierId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier Not Found");
        }
    }
}
