package com.project.inventorymanagementsystem.service;

import com.project.inventorymanagementsystem.model.Order;
import com.project.inventorymanagementsystem.model.Product;
import com.project.inventorymanagementsystem.model.User;
import com.project.inventorymanagementsystem.model.UserProduct;
import com.project.inventorymanagementsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderJpaService implements OrderRepository {
    @Autowired
    OrderJpaRepository orderJpaRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    UserProductJpaRepository userProductJpaRepository;

    @Autowired
    ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Order> getAllOrders(){
        List<Order> ordersList = orderJpaRepository.findAll();
        return new ArrayList<>(ordersList);
    }

    @Override
    public Order getOrderById(int orderId){
        try {
            return orderJpaRepository.findById(orderId).get();
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

//    @Override
//    public void deleteOrder(int orderId){
//        try{
//            Order existingOrder = getOrderById(orderId);
//            List<UserProduct> userProductList = existingOrder.getUserProducts();
//            List<UserProduct> emptyList = new ArrayList<>();
//            existingOrder.setUserProducts(emptyList);
//            orderJpaRepository.save(existingOrder);
//            for(UserProduct userProduct : userProductList){
//                userJpaRepository.deleteById(userProduct.getUserProductId());
//            }
//            orderJpaRepository.deleteById(orderId);
//            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
//        }
//        catch (NoSuchElementException e){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }

    @Override
    public Order addOrder(Order orderDetails) {
        User user = orderDetails.getUser();
        user = userJpaRepository.findById(user.getUserId()).get();
        orderDetails.setUser(user);
        List<UserProduct> userProducts = orderDetails.getUserProducts();
        List<UserProduct> userProducts1 = new ArrayList<>();
        float totalAmount = 0.0f;
        for(UserProduct userProduct : userProducts){
            int userProductId = userProduct.getUserProductId();
            Product product = productJpaRepository.findById(userProductId).get();
            float amount = product.getPrice()*userProduct.getQuantity();
            UserProduct newUserProduct = new UserProduct(0,product.getProductName(), product.getBrand(), product.getPrice(),userProduct.getQuantity(),amount,userProduct.getUserProductId(),product.getImageUrl());
            userProductJpaRepository.save(newUserProduct);
            userProducts1.add(newUserProduct);
            totalAmount  = totalAmount + amount;
        }
        orderDetails.setTotalAmount(totalAmount);
        orderDetails.setUserProducts(userProducts1);
        orderJpaRepository.save(orderDetails);
        return orderDetails;
    }

    @Override
    public Order updateOrder(int orderId,Order orderDetails) {
        try{
            Order existingOrder = orderJpaRepository.findById(orderId).get();
            if(orderDetails.getUser() != null){
                User user = orderDetails.getUser();
                int userId = user.getUserId();
                user = userJpaRepository.findById(userId).get();
                existingOrder.setUser(user);
            }
            if(orderDetails.getPaymentStatus() != null){
                existingOrder.setPaymentStatus(orderDetails.getPaymentStatus());
            }
            if(orderDetails.getDeliveryDate() != null){
                existingOrder.setDeliveryDate(orderDetails.getDeliveryDate());
            }

            float totalAmount=0.0f;
            float sameProductAmount = 0.0f;
            if(orderDetails.getUserProducts() != null){
                List<UserProduct> userProductsList = existingOrder.getUserProducts();
                ArrayList<Integer> productIdsList = new ArrayList<>();
                for(UserProduct userProduct : userProductsList){
                    productIdsList.add(userProduct.getProductId());
                }
                for(UserProduct userProduct : orderDetails.getUserProducts()){
                    sameProductAmount = 0.0f;
                    int productId = userProduct.getUserProductId();
                    if(productIdsList.contains(productId)){
                        for(UserProduct userProduct1 : userProductsList){
                            if(userProduct1.getProductId() == productId){
                                sameProductAmount = sameProductAmount +userProduct.getQuantity()*userProduct1.getPrice();
                                userProduct1.setQuantity(userProduct1.getQuantity()+userProduct.getQuantity());
                                userProduct1.setTotalAMount(userProduct1.getQuantity()*userProduct1.getPrice());

                            }
                        }
                    }
                    else{
                        Product product = productJpaRepository.findById(productId).get();
                        float amount = product.getPrice()*userProduct.getQuantity();
                        totalAmount = totalAmount + amount;
                        UserProduct newUserProduct = new UserProduct(0,product.getProductName(), product.getBrand(), product.getPrice(),userProduct.getQuantity(),amount, userProduct.getUserProductId(),product.getImageUrl());
                        userProductsList.add(newUserProduct);
                    }
                }

                userProductJpaRepository.saveAll(userProductsList);
                existingOrder.setUserProducts(userProductsList);
                totalAmount = totalAmount + existingOrder.getTotalAmount()+sameProductAmount;

            }
            existingOrder.setTotalAmount(totalAmount);
            orderJpaRepository.save(existingOrder);
            return existingOrder;
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Such Order is Found");
        }
    }

}
