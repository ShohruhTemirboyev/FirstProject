package com.example.myportfoliyaapp.repository;

import com.example.myportfoliyaapp.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {

}
