package com.catnest.admin.controller;

import com.catnest.admin.service.api.CatNestSystemService;
import com.catnest.common.core.domain.out.ApiRequest;
import com.catnest.common.core.domain.out.OutApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CatNestAdminController {

    @Autowired
    private CatNestSystemService catNestSystemService;

    @GetMapping("/test")
    public String test() {
        log.info("请求test方法");
        OutApiResponse<String> ceshi = catNestSystemService.test(new ApiRequest<>("ceshi", String.valueOf(System.currentTimeMillis())));
        return ceshi.getData();
    }

}
