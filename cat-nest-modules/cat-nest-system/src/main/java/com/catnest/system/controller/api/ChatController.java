package com.catnest.system.controller.api;

import com.catnest.common.core.domain.ApiResponse;
import com.catnest.system.entity.MessageContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {


    @PostMapping("/send")
    public ApiResponse<String> sendMsg(@RequestBody MessageContext context) {

        return ApiResponse.doSuccess("");
    }


    @GetMapping("/polling")
    public ApiResponse<String> polling() {

        return null;
    }




}
