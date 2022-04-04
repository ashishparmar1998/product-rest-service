package com.assignment.productrestservice.controller;

import com.assignment.productrestservice.model.Product;
import com.assignment.productrestservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{searchCriteria}/{param}")
    public List<Product> getProductByName(@PathVariable("searchCriteria") String searchCriteria, @PathVariable("param") String param) {
        List<Product> productList = new ArrayList<>();
        if (searchCriteria.equalsIgnoreCase("name")) {
            productList = productService.findByName(param);
        }
        if (searchCriteria.equalsIgnoreCase("category")) {
            productList = productService.findByCategory(param);
        }
        if (searchCriteria.equalsIgnoreCase("type")) {
            productList = productService.findByType(param);
        }
        return productList;
    }


    @GetMapping("/products/price/{min}/{max}")
    public List<Product> findByPrice(@PathVariable("min") double min, @PathVariable("max") double max) {
        return productService.findByPriceBetween(min, max);
    }
}
