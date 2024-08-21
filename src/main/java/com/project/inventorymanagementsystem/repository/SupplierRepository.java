package com.project.inventorymanagementsystem.repository;


import com.project.inventorymanagementsystem.model.Supplier;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface SupplierRepository {
    ArrayList<Supplier> getSuppliers();

    Supplier addSupplier(Supplier newSupplier);

    Supplier getSupplierById(int supplierId);

    Supplier updateSupplier(int supplierId, Supplier updateDetails);

    ResponseEntity<String> deleteSupplier(int supplierId);
}
