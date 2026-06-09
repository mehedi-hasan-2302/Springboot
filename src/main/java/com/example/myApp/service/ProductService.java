package com.example.myApp.service;

import com.example.myApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Mobile", 20000),
            new Product(102,"Laptop", 50000),
            new Product(103, "Mouse", 1500))
    );

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int prodId){
        return products.stream()
                .filter(product -> product.getId() == prodId)
                .findFirst().get();
    }

    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index =0;
        for(int i=0; i<products.size(); i++){
            //System.out.println(prod.getId());
            System.out.println(products.get(i).getId());
            if(products.get(i).getId() == prod.getId()) index = i;
        }
        products.set(index,prod);
    }

    public void deleteProduct(int id) {
        int index=0;
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getId()==id) index=i;
        }
        products.remove(index);
    }
}
