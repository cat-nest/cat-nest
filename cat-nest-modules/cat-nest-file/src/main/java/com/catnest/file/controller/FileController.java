package com.catnest.file.controller;

import com.catnest.file.service.impl.AliOssFileServiceImpl;
import com.catnest.starter.SpringContextUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {


    @GetMapping("/upload")
    public String upload() {
        AliOssFileServiceImpl bean = SpringContextUtil.getBean(AliOssFileServiceImpl.class);
        return bean.uploadFile(null);
    }


}
