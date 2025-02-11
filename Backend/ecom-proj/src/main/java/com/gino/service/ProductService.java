package com.gino.ecom_proj.service;

import com.gino.ecom_proj.model.Product;
import com.gino.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;


    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            // Set image properties from the MultipartFile
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());

            // For debugging, you can print out some details
            System.out.println("Received file: " + imageFile.getOriginalFilename() +
                    " (" + imageFile.getSize() + " bytes), content type: " + imageFile.getContentType());
        } else {
            System.out.println("No image file received or file is empty.");
        }
        return repo.save(product);
    }
}
