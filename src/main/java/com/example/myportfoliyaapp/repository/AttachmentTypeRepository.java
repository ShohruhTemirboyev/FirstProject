package com.example.myportfoliyaapp.repository;

import com.example.myportfoliyaapp.entity.AttachmentType;
import com.example.myportfoliyaapp.entity.enam.AttachmentTypeEnam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentTypeRepository extends JpaRepository<AttachmentType, UUID> {
AttachmentType findByAttachmentTypeEnam(AttachmentTypeEnam type);
}
