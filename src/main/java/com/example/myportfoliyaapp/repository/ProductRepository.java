package com.example.myportfoliyaapp.repository;

import com.example.myportfoliyaapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
