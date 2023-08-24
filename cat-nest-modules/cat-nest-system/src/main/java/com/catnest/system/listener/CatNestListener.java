package com.catnest.system.listener;

import com.catnest.system.domain.CatNestRecord;
import com.catnest.system.event.CatNestCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CatNestListener {


    @Async
    @EventListener
    public void onCreateCatNest(CatNestCreateEvent catNestCreateEvent) {
        CatNestRecord catNestRecord = catNestCreateEvent.getCatNestRecord();
        log.info("创建猫窝成功，执行事件;猫窝:{}", catNestRecord);
    }


}
