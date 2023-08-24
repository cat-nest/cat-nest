package com.catnest.system.serivce;

import com.catnest.core.annontation.ParamLog;
import com.catnest.core.domain.ApiResponse;
import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.domain.dto.JoinDTO;
import com.catnest.system.event.CatNestCreateEvent;
import com.catnest.system.mapper.CatNestRecordMapper;
import com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UnknownFormatConversionException;

@Service
public class CatNestService {

    @Autowired
    private CatNestRecordMapper catNestRecordMapper;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @ParamLog
    public long save(CatNestRecord catNestRecord) throws Exception {
        int insert = catNestRecordMapper.insertSelective(catNestRecord);
        if (insert > 0) {
            applicationEventPublisher.publishEvent(new CatNestCreateEvent(this,catNestRecord));
            return catNestRecord.getNestId();
        }
        throw new Exception("保存失败");

    }

    @ParamLog
    public ApiResponse<String> join(JoinDTO joinDTO) {
        Long nestId = joinDTO.getNestId();
        CatNestRecord catNestRecord = catNestRecordMapper.selectByPrimaryKey(nestId);
        if (!catNestRecord.getLockStatus()) {
            return ApiResponse.doSuccess("成功加入");
        } else {
            String lockPassword = joinDTO.getLockPassword();
            if (catNestRecord.getLockPassword().equals(lockPassword)) {
                return ApiResponse.doSuccess("成功加入");
            } else {
                return ApiResponse.doSuccess("密码错误");
            }
        }
    }
}
