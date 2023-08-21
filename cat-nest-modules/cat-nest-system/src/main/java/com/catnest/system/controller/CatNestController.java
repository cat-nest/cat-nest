package com.catnest.system.controller;

import com.catnest.core.domain.ApiResponse;
import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.domain.dto.JoinDTO;
import com.catnest.system.serivce.CatNestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.JavaObjectInputStreamAccess;

@RestController
@RequestMapping("/catnest")
@Slf4j
public class CatNestController {

    @Autowired
    private CatNestService catNestService;

    @GetMapping("/list")
    public ApiResponse<String> list() {

        return ApiResponse.doSuccess(null);
    }

    @PostMapping("/save")
    public ApiResponse<Long> save() {
        CatNestRecord catNestRecord = new CatNestRecord();
        catNestRecord.setNestName("测试名字");
        catNestRecord.setNestDesc("这是是测试用的简介");
        catNestRecord.setCreateUseId(2);
        try {
            long save = catNestService.save(catNestRecord);
            return ApiResponse.doSuccess(save);
        } catch (Exception e) {
            log.error("保存猫窝异常", e);
            return ApiResponse.doFail(e.getMessage());
        }
    }

    @PostMapping("/join")
    public ApiResponse<String> join(@RequestBody JoinDTO joinDTO) {
        return catNestService.join(joinDTO);
    }

}
