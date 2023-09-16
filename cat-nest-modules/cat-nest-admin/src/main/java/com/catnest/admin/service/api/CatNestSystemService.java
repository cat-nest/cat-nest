package com.catnest.admin.service.api;

import com.catnest.common.core.domain.out.ApiRequest;
import com.catnest.common.core.domain.out.OutApiResponse;
import com.catnest.system.AdminToSystemApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cat-nest-system")
@Component
public interface CatNestSystemService extends AdminToSystemApi {

    @GetMapping("/system/api/test")
    @Override
    OutApiResponse<String> test(@RequestParam(value = "apiRequest") ApiRequest<String> apiRequest);


}
