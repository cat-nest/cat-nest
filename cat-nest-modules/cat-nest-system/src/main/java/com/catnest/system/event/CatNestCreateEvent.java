package com.catnest.system.event;

import com.catnest.system.domain.CatNestRecord;
import org.springframework.context.ApplicationEvent;

public class CatNestCreateEvent extends ApplicationEvent {

    private final CatNestRecord catNestRecord;

    public CatNestCreateEvent(Object source, CatNestRecord catNestRecord) {
        super(source);
        this.catNestRecord = catNestRecord;
    }

    public CatNestRecord getCatNestRecord() {
        return catNestRecord;
    }
}
