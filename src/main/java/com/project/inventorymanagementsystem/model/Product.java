package com.project.inventorymanagementsystem.model;


import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_amount")
    private Float totalAmount;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    public Product(){}


    public Product(int productId, String productName, String brand, Float price, Float totalAmount, Integer quantity, Integer reorderLevel, int supplierId,String imageUrl,String description){
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.imageUrl = imageUrl;
        this.description = description;
        this.active = (this.quantity > this.reorderLevel);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
