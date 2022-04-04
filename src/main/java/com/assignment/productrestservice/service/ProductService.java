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

    public List<Product> addProducts(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    public List<Product> getSellerProduct(long sellerId) {
        return productRepository.findBySellerId(sellerId);
    }

    public Product findProductByProductIdAndSeller(long productId, long sellerId) {
        return productRepository.findByIdAndSellerId(productId, sellerId);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByType(String type) {
        return productRepository.findByType(type);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> findByPriceBetween(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }
}
