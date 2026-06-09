package com.example.myApp.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

    private int prodId;
    private String prodName;
    private int price;

    public Product(){

    }

    public Product(int prodId, String prodName, int price){
        this.prodId=prodId;
        this.prodName=prodName;
        this.price=price;
    }

//    public void setProdId(int prodId) {
//        this.prodId = prodId;
//    }
//
//    public void setProdName(String prodName) {
//        this.prodName = prodName;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

    public int getId(){
        return prodId;
    }

    public String getName(){
        return prodName;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                '}';
    }
}
