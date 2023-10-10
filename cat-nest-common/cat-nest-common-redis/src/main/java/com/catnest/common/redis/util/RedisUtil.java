package com.catnest.common.redis.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public <T> T getValue(String key, Class<T> clazz) {
        Object v = redisTemplate.opsForValue().get(key);
        return convert(v, clazz);
    }


    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    private <T> T convert(Object obj, Class<T> clazz) {
        if (clazz.isInstance(obj)) {
            return clazz.cast(obj);
        }
        return null;
    }


}
