package com.example.myportfoliyaapp.entity;

import com.example.myportfoliyaapp.entity.enam.AttachmentTypeEnam;
import com.example.myportfoliyaapp.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentType extends AbsEntity {
    @Enumerated(value = EnumType.STRING)
    private AttachmentTypeEnam attachmentTypeEnam;
    private int width;
    private int height;
    private Long size;
    private String contentType;
}
