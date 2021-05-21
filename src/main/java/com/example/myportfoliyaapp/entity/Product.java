package com.example.myportfoliyaapp.entity;

import com.example.myportfoliyaapp.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends AbsEntity {

    @ManyToOne(optional = false)
    private ProductType productType;

    @JoinTable(name="product_productSalesType",
            joinColumns = {@JoinColumn(name="product_id")},
            inverseJoinColumns = {@JoinColumn(name="productSalesType_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ProductSalesType> productSalesType;

    private String productName;

    @Column(nullable = false)
    private Long price;

   @ManyToOne
    private Currency currency;

    private String status;
    private String dicription;

    @OneToOne()
    private Attachment attachment;


}
