package com.example.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laptopshop.domain.Cart;
import com.example.laptopshop.domain.CartDetail;
import com.example.laptopshop.domain.Product;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
    CartDetail findByCartAndProduct(Cart cart, Product product);
    CartDetail save(CartDetail cartDetail);
}
