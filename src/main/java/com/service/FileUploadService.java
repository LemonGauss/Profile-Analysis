package com.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    void saveFile(MultipartFile file) throws IOException;
}
