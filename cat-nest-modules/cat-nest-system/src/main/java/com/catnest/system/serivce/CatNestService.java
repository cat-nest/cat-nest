package com.catnest.system.serivce;


import com.catnest.common.core.domain.ApiResponse;
import com.catnest.starter.annontation.ParamLog;
import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.domain.dto.JoinDTO;
import com.catnest.system.domain.dto.CatNestBuildDTO;
import com.catnest.system.domain.vo.CatNestInfoDTO;
import com.catnest.system.event.CatNestCreateEvent;
import com.catnest.system.mapper.CatNestRecordMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

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
            applicationEventPublisher.publishEvent(new CatNestCreateEvent(this, catNestRecord));
            return catNestRecord.getNestId();
        }
        throw new Exception("保存失败");

    }

    @ParamLog
    public CatNestInfoDTO get(String id) {
        CatNestRecord catNestRecord = catNestRecordMapper.selectByPrimaryKey(Long.parseLong(id));
       CatNestInfoDTO catNestInfoDTO = new CatNestInfoDTO();
        BeanUtils.copyProperties(catNestRecord, catNestInfoDTO);
        return catNestInfoDTO;
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
