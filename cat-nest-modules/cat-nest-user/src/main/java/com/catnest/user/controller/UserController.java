package com.catnest.user.controller;


import com.catnest.common.core.domain.ApiResponse;
import com.catnest.user.domain.vo.LoginVO;
import com.catnest.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody LoginVO info) {

        return userService.login(info);
    }

    @PostMapping("/logout")
    public ApiResponse<String> logout() {
        return userService.logout();
    }

}
