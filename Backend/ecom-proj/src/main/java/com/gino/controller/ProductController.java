package com.gino.ecom_proj.controller;

import com.gino.ecom_proj.model.Product;
import com.gino.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;
import java.util.PropertyPermission;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
       Product product = service.getProductById(id);

       if (product != null){
           return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }


    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestPart Product product, //question mark is a generic to because we dont know if we are returning plroduct or string
                                        @RequestPart MultipartFile imageFile){
        try{
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED); //this returns product
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); //this returns string
        }
    }


}



