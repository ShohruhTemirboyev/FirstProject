package com.example.myportfoliyaapp.serviceInterface;

import com.example.myportfoliyaapp.entity.Product;
import com.example.myportfoliyaapp.payloat.ApiResponse;
import com.example.myportfoliyaapp.payloat.ReqProduct;
import com.example.myportfoliyaapp.payloat.ResProduct;

import java.util.List;
import java.util.UUID;

public interface ProductServiceInterface {
    public ApiResponse save(ReqProduct reqProduct);

    public ApiResponse edit(UUID id, ReqProduct reqProduct);

    public ApiResponse delete(UUID id);

    public ResProduct getProduct(Product product);


}
