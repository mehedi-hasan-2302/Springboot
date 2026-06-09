package com.example.myApp.controller;

import com.example.myApp.model.Product;
import com.example.myApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    ProductService service;

    public ProductController(ProductService service){
        this.service=service;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Product prod = service.getProductById(prodId);
        if(prod!=null) return new ResponseEntity<>(prod, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PostMapping("/products/add")
    public ResponseEntity<?> addProduct(@ModelAttribute Product prod,
                                        @RequestPart MultipartFile imageFile){

        try{
            Product product= service.addProduct(prod,imageFile);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/products/{prodId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int prodId){
        Product product = service.getProductById(prodId);
        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @PutMapping("/products/update")
    public void updateProduct(@RequestBody Product prod){
        System.out.println(prod);
        service.updateProduct(prod);
    }


    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }
}
