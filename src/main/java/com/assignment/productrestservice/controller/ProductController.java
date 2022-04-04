package com.assignment.productrestservice.controller;

import com.assignment.productrestservice.model.Product;
import com.assignment.productrestservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/product/{sellerId}")
    public Product addOneProduct(@RequestBody Product product, @PathVariable("sellerId") long sellerId) {
        product.setSellerId(sellerId);
        return productService.addProduct(product);
    }

    @PostMapping("/products/{sellerId}")
    public List<Product> addMultipleProduct(@RequestBody List<Product> productList, @PathVariable("sellerId") long sellerId) {
        productList.forEach(product -> product.setSellerId(sellerId));
        return productService.addProducts(productList);
    }

    @GetMapping("/products/{sellerId}")
    public List<Product> getSellerProducts(@PathVariable("sellerId") long sellerId) {
        return productService.getSellerProduct(sellerId);
    }

    @PutMapping("/product/{sellerId}")
    public List<Product> updateProducts(@RequestBody List<Product> productsToUpdate, @PathVariable("sellerId") long sellerId) {
        List<Product> existingSellerProducts = productService.getSellerProduct(sellerId);
        productsToUpdate.forEach(product -> existingSellerProducts.forEach(sellerProduct -> {
            if (sellerProduct.getId() == product.getId() && sellerId == sellerProduct.getSellerId()) {
                sellerProduct.setName(product.getName());
                sellerProduct.setCategory(product.getCategory());
                sellerProduct.setType(product.getType());
                sellerProduct.setAddOn(product.getAddOn());
                sellerProduct.setPrice(product.getPrice());
            }
        }));
        return productService.addProducts(existingSellerProducts);
    }
}
