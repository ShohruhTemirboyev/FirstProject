package com.example.myportfoliyaapp.payloat;

import com.example.myportfoliyaapp.entity.Attachment;
import com.example.myportfoliyaapp.entity.Currency;
import com.example.myportfoliyaapp.entity.ProductSalesType;
import com.example.myportfoliyaapp.entity.ProductType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ResProduct {
    private ProductType productTypeId;
    private List<ProductSalesType> productSalesTypeId;
    private String productName;
    private Long price;
    private Currency currencyId;
    private String status;
    private String dicription;
    private Attachment attachment;

}
