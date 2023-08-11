package com.catnest.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catnest.core.constant.StrConstant;

@RestController
@RequestMapping("/system")
public class SystemController {

    @GetMapping("/health")
    public String health() {
        return StrConstant.SUCCESS;
    }

}
