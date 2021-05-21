package com.example.myportfoliyaapp.payloat;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ReqProduct {
    private Long productTypeId;
    private List<Long> productSalesTypeId;
    private String productName;
    private Long price;
    private Long currencyId;
    private String status;
    private String dicription;
    private String attachmentId;

}
