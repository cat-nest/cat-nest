package com.catnest.user.service;

import cn.dev33.satoken.stp.StpUtil;
import com.catnest.common.core.domain.ApiResponse;
import com.catnest.user.domain.CnUser;
import com.catnest.user.domain.vo.LoginVO;
import com.catnest.user.domain.vo.UserInfo;
import com.catnest.user.mapper.CnUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private CnUserMapper cnUserMapper;

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


    /**
     * 注册用户
     *
     * @param userInfo
     * @return
     */
    public ApiResponse<String> register(UserInfo userInfo) {

        CnUser cnUser = new CnUser();

        BeanUtils.copyProperties(userInfo, cnUser);


        cnUser.setRegisterDt(new Date());
        int insert = cnUserMapper.insert(cnUser);

        return null;
    }
}
