package com.project.inventorymanagementsystem.model;


import jakarta.persistence.*;

@Entity
@Table(name = "user_product")
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_product_id")
    private int userProductId;

    @Column(name = "name")
    private String name;



    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "totalAmount")
    private Float totalAMount;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "image_url")
    private String imageUrl;

    public UserProduct(){}

    public UserProduct(int userProductId, String name, String brand, Float price, Integer quantity, Float totalAMount,int productId,String imageUrl) {
        this.userProductId = userProductId;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.totalAMount = totalAMount;
        this.productId = productId;
        this.imageUrl = imageUrl;
    }


    public int getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(int userProductId) {
        this.userProductId = userProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalAMount() {
        return totalAMount;
    }

    public void setTotalAMount(Float totalAMount) {
        this.totalAMount = totalAMount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
