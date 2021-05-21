package com.example.myportfoliyaapp.controller;

import com.example.myportfoliyaapp.entity.Product;
import com.example.myportfoliyaapp.payloat.ApiResponse;
import com.example.myportfoliyaapp.payloat.ReqProduct;
import com.example.myportfoliyaapp.repository.ProductRepository;
import com.example.myportfoliyaapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    @PostMapping("/save")
    public HttpEntity<?> addProduct(@RequestBody ReqProduct reqProduct){
        ApiResponse response=productService.save(reqProduct);
        return ResponseEntity.status(response.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getProduct(@PathVariable UUID id){
        Product product=productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
        return ResponseEntity.ok(productService.getProduct(product));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteComplex(@PathVariable UUID id){
        ApiResponse respons=productService.delete(id);
        return ResponseEntity.status(respons.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(respons);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editComplex(@PathVariable UUID id,@RequestBody ReqProduct reqProduct){
        ApiResponse respons=productService.edit(id,reqProduct);
        return ResponseEntity.status(respons.isSuccess()?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(respons);
    }

}
