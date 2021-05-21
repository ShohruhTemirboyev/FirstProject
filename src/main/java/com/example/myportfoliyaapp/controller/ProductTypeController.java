package com.example.myportfoliyaapp.controller;

import com.example.myportfoliyaapp.payloat.ApiResponse;
import com.example.myportfoliyaapp.payloat.ReqProductType;
import com.example.myportfoliyaapp.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;
    @PostMapping("/add")
    public HttpEntity<?> addProductType(@RequestBody ReqProductType reqProductType){
        ApiResponse response=productTypeService.saveProductType(reqProductType);
        return ResponseEntity.status(response.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(response);
    }
}
