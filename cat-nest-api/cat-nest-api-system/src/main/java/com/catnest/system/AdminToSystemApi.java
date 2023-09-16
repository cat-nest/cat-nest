package com.catnest.system;

import com.catnest.common.core.domain.out.ApiRequest;
import com.catnest.common.core.domain.out.OutApiResponse;

public interface AdminToSystemApi {

    OutApiResponse<String> test(ApiRequest<String> apiRequest);
}
