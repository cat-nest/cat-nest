package com.catnest.file.service.impl;

import com.catnest.file.service.IFileService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AliOssFileServiceImpl implements IFileService {
    @Override
    public String uploadFile(MultipartFile file) {
        return "alibaba oss ";
    }

    @Override
    public String download() {
        return null;
    }
}
