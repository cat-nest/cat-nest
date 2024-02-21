package com.catnest.file.controller;

import com.catnest.common.core.utils.SpringContextUtil;
import com.catnest.file.service.impl.AliOssFileServiceImpl;
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
