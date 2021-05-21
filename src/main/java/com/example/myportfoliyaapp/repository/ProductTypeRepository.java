package com.example.myportfoliyaapp.repository;

import com.example.myportfoliyaapp.entity.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType,Long> {
    boolean existsByName(String name);


}
