package com.assignment.productrestservice.controller;

import com.assignment.productrestservice.exception.ResourceNotFoundException;
import com.assignment.productrestservice.model.Product;
import com.assignment.productrestservice.model.Seller;
import com.assignment.productrestservice.service.ProductService;
import com.assignment.productrestservice.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;

    @PostMapping("/seller")
    public Seller registerSeller(@RequestBody Seller seller){
        return sellerService.registerSeller(seller);
    }

    @GetMapping("/sellers")
    public List<Seller> getAllRegisteredSeller(){
        return sellerService.getAllSeller();
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

    @DeleteMapping("/product/{productId}/{sellerId}")
    public void deleteProduct(@PathVariable("productId") long productId, @PathVariable("sellerId") long sellerId) {
        Product product = productService.findProductByProductIdAndSeller(productId, sellerId);
        if (product == null) {
            throw new ResourceNotFoundException("product not found");
        } else {
            productService.deleteProduct(product);
        }
    }
}
