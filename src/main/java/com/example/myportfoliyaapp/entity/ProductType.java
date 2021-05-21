package com.example.myportfoliyaapp.entity;

import com.example.myportfoliyaapp.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
public class ProductType extends AbsNameEntity {

}
