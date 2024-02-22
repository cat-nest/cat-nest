package com.catnest.system.controller;


import com.catnest.common.core.domain.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthyController {


    @GetMapping("/healthy")
    public ApiResponse<String> healthy() {
        log.info("请求成功");
        return ApiResponse.doSuccess("成功");
    }

}
