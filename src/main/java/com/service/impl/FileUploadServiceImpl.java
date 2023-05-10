package com.service.impl;

import com.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public void saveFile(MultipartFile file) throws IOException {
        // 获取PDF文件的字节数组
        byte[] pdfBytes = file.getBytes();

        // 获取保存PDF文件的路径
        String savePath = "D:/upload/";

        // 创建文件保存目录
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        // 生成唯一的文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = uuid + file.getOriginalFilename();

        // 保存PDF文件
        File saveFile = new File(savePath + fileName);
        FileOutputStream fos = new FileOutputStream(saveFile);
        fos.write(pdfBytes);
        fos.flush();
        fos.close();
    }
}
