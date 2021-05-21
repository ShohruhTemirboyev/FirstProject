package com.example.myportfoliyaapp.controller;

import com.example.myportfoliyaapp.payloat.ApiResponseModel;
import com.example.myportfoliyaapp.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/attach")
public class AttachmentController {
   @Autowired
    AttachmentService attachmentService;
    @PostMapping("/upload")
    public HttpEntity<?> addAttachment(MultipartHttpServletRequest request) throws IOException {
        ApiResponseModel responseModel=attachmentService.saveFile(request);
        return ResponseEntity.status(responseModel.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(responseModel);

    }
    @GetMapping("{id}")
    public HttpEntity<?> getAttachment(@PathVariable UUID id){
        return attachmentService.getAttachmentContent(id);
    }
}
