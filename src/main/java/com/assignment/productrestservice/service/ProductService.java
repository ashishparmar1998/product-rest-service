package com.assignment.productrestservice.service;

import com.assignment.productrestservice.model.Product;
import com.assignment.productrestservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> addProducts(List<Product> productList){
        return productRepository.saveAll(productList);
    }

    public List<Product> getSellerProduct(long sellerId) {
        return productRepository.findBySellerId(sellerId);
    }
}
