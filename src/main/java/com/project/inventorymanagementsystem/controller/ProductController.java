package com.project.inventorymanagementsystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.project.inventorymanagementsystem.model.Product;
import com.project.inventorymanagementsystem.service.ProductJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    @Autowired
    ProductJpaService productJpaService;

    @GetMapping("/products")
    public ArrayList<Product> getProducts(){
        return productJpaService.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product newProduct){
        return productJpaService.addProduct(newProduct);
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId){
        return productJpaService.getProductById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProductDetails(@PathVariable("productId") int productId,@RequestBody Product updateDetails){
        return productJpaService.updateProductDetails(productId,updateDetails);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId){
         productJpaService.deleteProduct(productId);
    }

}
