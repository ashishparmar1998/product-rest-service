package com.assignment.productrestservice.repository;

import com.assignment.productrestservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findBySellerId(long sellerId);
    Product findByIdAndSellerId(long id, long sellerId);
}
