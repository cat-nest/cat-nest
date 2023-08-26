package com.catnest.system.controller;

import com.catnest.common.core.domain.ApiResponse;
import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.domain.dto.JoinDTO;
import com.catnest.system.domain.vo.CatNestVo;
import com.catnest.system.serivce.CatNestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse<Long> save(@RequestBody CatNestVo catNestVo) {

        CatNestRecord catNestRecord = new CatNestRecord();

        BeanUtils.copyProperties(catNestVo, catNestRecord);

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
