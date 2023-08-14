package com.catnest.file.controller;

import com.catnest.file.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    @Autowired
    @Qualifier("aliOssFileServiceImpl")
    private IFileService fileService;

    @GetMapping("/upload")
    public String upload() {
        return fileService.uploadFile(null);
    }


}
