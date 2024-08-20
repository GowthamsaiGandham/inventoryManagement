package com.project.inventorymanagementsystem.service;


import com.project.inventorymanagementsystem.model.Product;
import com.project.inventorymanagementsystem.repository.ProductJpaRepository;
import com.project.inventorymanagementsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Product> getProducts(){
        List<Product> productsList = productJpaRepository.findAll();
        return new ArrayList<>(productsList);
    }

    @Override
    public Product addProduct(Product newProduct) {
        newProduct.setTotalAmount(newProduct.getQuantity()*newProduct.getPrice());
        productJpaRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public Product getProductById(int productId){
        try{
            return  productJpaRepository.findById(productId).get();
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product is not available");
        }
    }

    @Override
    public Product updateProductDetails(int productId,Product updateDetails) {
        try{
            Product existingProduct = productJpaRepository.findById(productId).get();
            if(updateDetails.getProductName() != null){
                existingProduct.setProductName(updateDetails.getProductName());
            }
            if(updateDetails.getBrand() != null){
                existingProduct.setBrand(updateDetails.getBrand());
            }
            if(updateDetails.getPrice() != null){
                existingProduct.setPrice(updateDetails.getPrice());
            }
            if(updateDetails.getQuantity() != null){
                existingProduct.setQuantity(updateDetails.getQuantity());
            }
            existingProduct.setTotalAmount(existingProduct.getQuantity()*existingProduct.getPrice());
            if(updateDetails.getReorderLevel() != null){
                existingProduct.setReorderLevel(updateDetails.getReorderLevel());
            }
            if(updateDetails.getActive() != null){
                existingProduct.setActive(updateDetails.getActive());
            }
            if(updateDetails.getSupplierId() != 0){
                existingProduct.setSupplierId(updateDetails.getSupplierId());
            }
            productJpaRepository.save(existingProduct);
            return existingProduct;
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product is not available");
        }

    }

    @Override
    public void deleteProduct(int productId) {
            getProductById(productId);
            productJpaRepository.deleteById(productId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Product is successfully deleted");
    }
}
