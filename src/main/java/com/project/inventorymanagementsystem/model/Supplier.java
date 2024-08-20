package com.project.inventorymanagementsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "mob_num")
    private String mobileNum;

    @Column(name = "address")
    private String address;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany
    @JoinColumn(name = "supplier_id")
    private List<Product> productsList = new ArrayList<>();

    public Supplier(){}

    public Supplier(int supplierId,String supplierName,String mobileNum,String address,Boolean active,List<Product> productsList,String imageUrl){
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.mobileNum = mobileNum;
        this.address = address;
        this.active = active;
        this.productsList = productsList;
        this.imageUrl = imageUrl;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
