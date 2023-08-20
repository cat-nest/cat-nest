package com.catnest.system.serivce;

import com.catnest.core.annontation.ParamLog;
import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.mapper.CatNestRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatNestService {

    @Autowired
    private CatNestRecordMapper catNestRecordMapper;

    @ParamLog
    public long save(CatNestRecord catNestRecord) throws Exception {
        int insert = catNestRecordMapper.insertSelective(catNestRecord);
        if (insert > 0) {
            return catNestRecord.getNestId();
        }
        throw new Exception("保存失败");

    }

}
