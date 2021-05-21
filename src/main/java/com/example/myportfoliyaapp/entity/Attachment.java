package com.example.myportfoliyaapp.entity;

import com.example.myportfoliyaapp.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attachment extends AbsEntity {
private String name;
private String contentType;
private Long size;

}
