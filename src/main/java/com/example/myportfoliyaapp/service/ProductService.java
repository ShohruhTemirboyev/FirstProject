package com.example.myportfoliyaapp.service;

import com.example.myportfoliyaapp.entity.Attachment;
import com.example.myportfoliyaapp.entity.Currency;
import com.example.myportfoliyaapp.entity.Product;
import com.example.myportfoliyaapp.entity.ProductType;
import com.example.myportfoliyaapp.payloat.ApiResponse;
import com.example.myportfoliyaapp.payloat.ReqProduct;
import com.example.myportfoliyaapp.payloat.ResProduct;
import com.example.myportfoliyaapp.repository.*;
import com.example.myportfoliyaapp.serviceInterface.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    ProductSalesTypeRepository productSalesTypeRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public ApiResponse save(ReqProduct reqProduct) {
        ApiResponse response=new ApiResponse();
        try {
            Product product=new Product();
            Optional<ProductType> typeId=productTypeRepository.findById(reqProduct.getProductTypeId());
            if (typeId.isPresent()) {
                product.setProductType(productTypeRepository.findById(reqProduct.getProductTypeId()).get());
            }
            else {
                 response.setMessage("id did not found ");
                 response.setSuccess(false);
                 return response;
            }
            product.setProductSalesType(productSalesTypeRepository.findAllById(reqProduct.getProductSalesTypeId()));
            product.setProductName(reqProduct.getProductName());
            Optional<Attachment> attachmentId=attachmentRepository.findById(UUID.fromString(reqProduct.getAttachmentId()));
            if (attachmentId.isPresent()) {
                product.setAttachment(attachmentRepository.findById(UUID.fromString(reqProduct.getAttachmentId())).get());
            }
            else {
                response.setMessage("id did not found ");
                response.setSuccess(false);
                return response;
            }
            product.setPrice(reqProduct.getPrice());
            Optional<Currency> byId = currencyRepository.findById(reqProduct.getCurrencyId());
            if (byId.isPresent()){
                product.setCurrency(currencyRepository.findById(reqProduct.getCurrencyId()).get());
            }else {
                response.setMessage("id did not found ");
                response.setSuccess(false);
                return response;
            }
            product.setDicription(reqProduct.getDicription());
            product.setStatus(reqProduct.getStatus());
            productRepository.save(product);
           response.setSuccess(true);
           response.setMessage("Saqlandi");

        }
        catch (Exception ex){
         response.setSuccess(false);
         response.setMessage("Saqlashda xatolik!!!");
        }
        return response;
    }

    @Override
    public ApiResponse edit(UUID id, ReqProduct reqProduct) {

        ApiResponse response = new ApiResponse();
        try {Optional<Product> optionalProduct=productRepository.findById(id);
            if (optionalProduct.isPresent()) {
                Product product = new Product();
                Optional<ProductType> typeId = productTypeRepository.findById(reqProduct.getProductTypeId());
                if (typeId.isPresent()) {
                    product.setProductType(productTypeRepository.findById(reqProduct.getProductTypeId()).get());
                } else {
                    response.setMessage("id did not found ");
                    response.setSuccess(false);
                    return response;
                }
                product.setProductSalesType(productSalesTypeRepository.findAllById(reqProduct.getProductSalesTypeId()));
                product.setProductName(reqProduct.getProductName());
                Optional<Attachment> attachmentId = attachmentRepository.findById(UUID.fromString(reqProduct.getAttachmentId()));
                if (attachmentId.isPresent()) {
                    product.setAttachment(attachmentRepository.findById(UUID.fromString(reqProduct.getAttachmentId())).get());
                } else {
                    response.setMessage("id did not found ");
                    response.setSuccess(false);
                    return response;
                }
                product.setPrice(reqProduct.getPrice());
                Optional<Currency> byId = currencyRepository.findById(reqProduct.getCurrencyId());
                if (byId.isPresent()) {
                    product.setCurrency(currencyRepository.findById(reqProduct.getCurrencyId()).get());
                } else {
                    response.setMessage("id did not found ");
                    response.setSuccess(false);
                    return response;
                }
                product.setDicription(reqProduct.getDicription());
                product.setStatus(reqProduct.getStatus());
                productRepository.save(product);
                response.setSuccess(true);
                response.setMessage("Saqlandi");

            }
        }
        catch(Exception ex){
                response.setSuccess(false);
                response.setMessage("Saqlashda xatolik!!!");
            }
            return response;

    }

    @Override
    public ApiResponse delete(UUID id) {

        ApiResponse respons=new ApiResponse();
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            respons.setMessage("O'chirildi");
            respons.setSuccess(true);
            return respons;
        }
        respons.setMessage("Bunday product mavjud emas");
        respons.setSuccess(false);
        return respons;
    }

    @Override
    public ResProduct getProduct(Product product) {
          ResProduct resProduct=new ResProduct();
          resProduct.setProductName(product.getProductName());
          resProduct.setPrice(product.getPrice());
          resProduct.setDicription(product.getDicription());
          resProduct.setStatus(product.getStatus());
          resProduct.setProductTypeId(product.getProductType());
          resProduct.setCurrencyId(product.getCurrency());
          resProduct.setAttachment(product.getAttachment());
          resProduct.setProductSalesTypeId(product.getProductSalesType());
          return resProduct;
    }


}
