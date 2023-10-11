package com.catnest.common.redis.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public <T> T getValue(String key, Class<T> clazz) {
        Object v = redisTemplate.opsForValue().get(key);
        return convert(v, clazz);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public <T> T getValueAndDel(String key, Class<T> clazz) {
        Object v = redisTemplate.opsForValue().getAndDelete(key);
        return convert(v, clazz);
    }

    public Object getValueAndDel(String key) {
        return redisTemplate.opsForValue().getAndDelete(key);
    }


    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setValue(String key, Object value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    public Boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    public Long deleteKeys(String... keys) {
        if (keys.length == 0) {
            return 0L;
        }
        return redisTemplate.delete(Arrays.asList(keys));
    }

    public Boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 反省类型转换
     *
     * @param obj   原对象
     * @param clazz 需要转换的类型
     * @param <T>   范型规范
     * @return 转换成功的对象
     */
    private <T> T convert(Object obj, Class<T> clazz) {
        if (obj == null) {
            return null;
        }
        if (clazz.isInstance(obj)) {
            return clazz.cast(obj);
        }
        return null;
    }


}
