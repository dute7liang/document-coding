package com.duteliang.webbase.lock;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2019-12-24 14:16
 */
@Component
public class RedLock {

    private final StringRedisTemplate stringRedisTemplate;

    public RedLock(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void lock(String key){
//        stringRedisTemplate.opsForValue().setIfAbsent(key, , , )
    }

    public void unlock(String id){

    }


}
