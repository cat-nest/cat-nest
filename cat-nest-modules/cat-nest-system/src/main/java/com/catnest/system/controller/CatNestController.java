package com.catnest.system.controller;

import com.catnest.common.core.domain.ApiResponse;
import com.catnest.common.datasource.handler.EncryptHandler;
import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.domain.dto.CatNestBuildDTO;
import com.catnest.system.domain.dto.JoinDTO;
import com.catnest.system.domain.vo.CatNestInfoVO;
import com.catnest.system.serivce.CatNestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/catnest")
public class CatNestController {

    @Autowired
    private CatNestService catNestService;

    @GetMapping("/list")
    public ApiResponse<List<CatNestInfoVO>> list() {
        List<CatNestInfoVO> result = catNestService.list();
        return ApiResponse.doSuccess(result);
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
    public ApiResponse<CatNestInfoVO> get(String id) {
        CatNestInfoVO catNestInfoVO = catNestService.get(id);
        if (Objects.nonNull(catNestInfoVO)) {
            return ApiResponse.doSuccess(catNestInfoVO);
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
        return "success";
    }

}
