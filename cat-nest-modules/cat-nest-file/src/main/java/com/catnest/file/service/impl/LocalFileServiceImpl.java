package com.catnest.file.service.impl;

import com.catnest.file.service.IFileService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalFileServiceImpl implements IFileService {

    @Override
    public String uploadFile(MultipartFile file) {
        return "upload";
    }

    @Override
    public String download() {
        return "down";
    }
}
