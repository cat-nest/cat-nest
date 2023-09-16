package com.catnest.system.controller.api;

import com.catnest.common.core.domain.out.ApiRequest;
import com.catnest.common.core.domain.out.OutApiResponse;
import com.catnest.system.AdminToSystemApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CatNestOutApiController implements AdminToSystemApi {


    @GetMapping("/test")
    @Override
    public OutApiResponse<String> test(ApiRequest<String> apiRequest) {
        return OutApiResponse.doSuccess("请求chengg");
    }
}
