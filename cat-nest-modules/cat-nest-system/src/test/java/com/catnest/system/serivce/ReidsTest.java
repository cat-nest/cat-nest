package com.catnest.system.serivce;

import com.catnest.common.redis.util.RedisUtil;
import com.catnest.system.domain.CatNestRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReidsTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void testSet() {
        CatNestRecord catNestRecord = new CatNestRecord();
        catNestRecord.setNestName("猫窝");
        redisUtil.setValue("nests", catNestRecord);
    }

    @Test
    public void testGet() {
        CatNestRecord nests = redisUtil.getValue("nests", CatNestRecord.class);
        System.out.println(nests);
    }

}