package com.assignment.productrestservice.service;

import com.assignment.productrestservice.model.Seller;
import com.assignment.productrestservice.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    public Seller registerSeller(Seller seller){
        return sellerRepository.save(seller);
    }

    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }
}
