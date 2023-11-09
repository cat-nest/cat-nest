package com.catnest.user.service;

import cn.dev33.satoken.stp.StpUtil;
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


    public ApiResponse<String> logout() {
        try {
            StpUtil.checkLogin();
        } catch (Exception e) {
            return ApiResponse.doFail("当前未登录");
        }
        StpUtil.logout();
        return ApiResponse.doSuccess("注销成功");
    }


}
