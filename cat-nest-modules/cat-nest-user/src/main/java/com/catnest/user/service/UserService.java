package com.catnest.user.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.catnest.common.core.domain.ApiResponse;
import com.catnest.user.domain.vo.LoginVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public ApiResponse<String> login(LoginVO info) {
        String userName = info.getUserName();
        String password = info.getPassword();
        //查表
        if (userName.equals("yiwyn") && password.equals("123456")) {
            StpUtil.login(userName);
            return ApiResponse.doSuccess("登录成功");
        }
        return ApiResponse.doFail("登录失败");

    }


}
