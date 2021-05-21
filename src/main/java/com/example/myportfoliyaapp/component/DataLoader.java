package com.example.myportfoliyaapp.component;

import com.example.myportfoliyaapp.entity.Currency;
import com.example.myportfoliyaapp.entity.ProductSalesType;
import com.example.myportfoliyaapp.entity.User;
import com.example.myportfoliyaapp.entity.enam.RoleName;
import com.example.myportfoliyaapp.repository.CurrencyRepository;
import com.example.myportfoliyaapp.repository.ProductSalesTypeRepository;
import com.example.myportfoliyaapp.repository.RoleRepository;
import com.example.myportfoliyaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ProductSalesTypeRepository productSalesTypeRepository;
    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")){
            userRepository.save(new User(
                    "+998933119525",
                    passwordEncoder.encode("12345"),
                    "Shohruh Temirboyev",
                    Collections.singletonList(roleRepository.findByRoleName(RoleName.ROLE_ADMIN))));
            productSalesTypeRepository.save(new ProductSalesType("Sotish"));
            productSalesTypeRepository.save(new ProductSalesType("Ayir boshlash"));
            currencyRepository.save(new Currency("Sum"));
            currencyRepository.save(new Currency("y.e"));

        }
    }
}
