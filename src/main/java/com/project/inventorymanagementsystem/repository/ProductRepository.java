package com.project.inventorymanagementsystem.repository;

import com.project.inventorymanagementsystem.model.Product;

import java.util.ArrayList;

public interface ProductRepository {
    ArrayList<Product> getProducts();

    Product addProduct(Product newProduct);

    Product getProductById(int productId);

    Product updateProductDetails(int productId,Product updateDetails);

    void deleteProduct(int productId);
}
