package com.catnest.system.listener;

import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.event.CatNestCreateEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CatNestListener {


    @Autowired
    private StringRedisTemplate redisTemplate;


    //todo  magic-value need deal
    @Async
    @EventListener
    public void onCreateCatNest(CatNestCreateEvent catNestCreateEvent) throws JsonProcessingException {
        CatNestRecord catNestRecord = catNestCreateEvent.getCatNestRecord();
        log.info("创建猫窝成功，执行事件;猫窝信息:{}", catNestRecord);
        ObjectMapper om = new ObjectMapper();
        redisTemplate.boundHashOps("latest_create").put(String.valueOf(catNestRecord.getNestId()), om.writeValueAsString(catNestRecord));
    }


}
