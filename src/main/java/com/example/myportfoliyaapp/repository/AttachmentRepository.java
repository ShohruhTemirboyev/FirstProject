package com.example.myportfoliyaapp.repository;

import com.example.myportfoliyaapp.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
