package com.example.myportfoliyaapp.service;

import com.example.myportfoliyaapp.entity.ProductType;
import com.example.myportfoliyaapp.payloat.ApiResponse;
import com.example.myportfoliyaapp.payloat.ReqProductType;
import com.example.myportfoliyaapp.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;
    public ApiResponse saveProductType(ReqProductType reqProductType){
        ApiResponse response=new ApiResponse();
        try {
            if (!productTypeRepository.existsByName(reqProductType.getName())){
            ProductType productType=new ProductType();
            productType.setName(reqProductType.getName());
            productTypeRepository.save(productType);
            response.setMessage("Saqlandi");
            response.setSuccess(true);
        }
        else{
            response.setSuccess(false);
            response.setMessage("Bunday turdagi maxsulotlar turi bor");
        }
        }
        catch (Exception ex){
           response.setSuccess(false);
           response.setMessage("Malumotni saqlashda xatolik!!!");
        }
        return response;
    }
}
