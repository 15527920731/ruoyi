package com.jewelry.system.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.concurrent.TimeUnit;

@Configuration
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 存数据
     * @param key
     * @param value
     */
    public void set(String key , Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 存数据
     * @param key 键
     * @param value 值
     * @param exp 过期时间 默认秒
     * @param s 使用 时还是分还是秒，默认秒
     */
    public void set(String key , Object value , int exp,TimeUnit s){
        if( s==null ){
            s = TimeUnit.SECONDS;
        }
        redisTemplate.opsForValue().set(key,value,exp, s);
    }

    /**
     * 获取数据
     * @param key
     * @return
     */
    public <T>T get(String key){
        return (T)redisTemplate.opsForValue().get(key);
    }

}
