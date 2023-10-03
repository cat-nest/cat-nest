package com.catnest.system.controller;

import com.catnest.common.core.domain.ApiResponse;
import com.catnest.common.datasource.handler.EncryptHandler;
import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.domain.dto.JoinDTO;
import com.catnest.system.domain.dto.CatNestBuildDTO;
import com.catnest.system.domain.vo.CatNestInfoDTO;
import com.catnest.system.serivce.CatNestService;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/catnest")
public class CatNestController {

    @Autowired
    private CatNestService catNestService;

    @GetMapping("/list")
    public ApiResponse<String> list() {

        return ApiResponse.doSuccess(null);
    }

    @PostMapping("/save")
    public ApiResponse<Long> save(@RequestBody CatNestBuildDTO catNestBuildDTO) {

        CatNestRecord catNestRecord = new CatNestRecord();

        BeanUtils.copyProperties(catNestBuildDTO, catNestRecord);

        catNestRecord.setNestName("测试名字");
        catNestRecord.setNestDesc("这是是测试用的简介");
        catNestRecord.setLockPassword("123456");
        catNestRecord.setCreateUseId(2);
        try {
            long save = catNestService.save(catNestRecord);
            return ApiResponse.doSuccess(save);
        } catch (Exception e) {
            log.error("保存猫窝异常", e);
            return ApiResponse.doFail(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ApiResponse<CatNestInfoDTO> get(String id) {
        CatNestInfoDTO catNestInfoDTO = catNestService.get(id);
        if (Objects.nonNull(catNestInfoDTO)) {
            return ApiResponse.doSuccess(catNestInfoDTO);
        }
        return ApiResponse.doFail("没有找到这个猫窝");

    }

    @PostMapping("/join")
    public ApiResponse<String> join(@RequestBody JoinDTO joinDTO) {
        return catNestService.join(joinDTO);
    }

    @Autowired
    private EncryptHandler encryptHandler;

    @GetMapping("/health")
    public String health() {
        String securityKey = encryptHandler.securityKey;
        return securityKey;
    }

}
