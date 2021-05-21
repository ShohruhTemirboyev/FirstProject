package com.example.myportfoliyaapp.repository;

import com.example.myportfoliyaapp.entity.Attachment;
import com.example.myportfoliyaapp.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    Optional<AttachmentContent> findByAttachment(Attachment attachment);
}
