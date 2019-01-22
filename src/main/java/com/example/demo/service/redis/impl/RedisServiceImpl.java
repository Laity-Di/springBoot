package com.example.demo.service.redis.impl;

import com.example.demo.service.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: Ryan
 * @since: 2018/11/9 11:44
 * @description:
 * @modifyTime:
 * @modifier:
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /*****************************String*****************************************/
    @Override
    public boolean set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    @Override
    public boolean set(String key, int timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, timeout, timeout);
        return true;
    }

    @Override
    public boolean set(String key, Object value, int timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
        return true;
    }

    @Override
    public boolean setIfAbsent(String key, Object value) {

        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    @Override
    public boolean multiSet(Map<String, Object> map) {
        redisTemplate.opsForValue().multiSet(map);
        return true;
    }

    @Override
    public Object getAndSet(String key, Object value) {

        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    @Override
    public Object get(String key) {

        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
        return true;
    }
    /**************************************Hash**************************************/
    @Override
    public boolean put(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key,hashKey,value);
        return true;
    }

    @Override
    public boolean putIfAbsent(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
        return true;
    }

    @Override
    public boolean putAll(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
        return true;
    }

    @Override
    public boolean hasKey(String key, String hashKey) {

        return redisTemplate.opsForHash().hasKey(key,hashKey);
    }

    @Override
    public Object get(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key,hashKey);
    }

    @Override
    public Object entries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public boolean delete(String key, Object... hashKeys) {
        redisTemplate.opsForHash().delete(key, hashKeys);
        return true;
    }

    @Override
    public Object keys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    @Override
    public Object values(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    @Override
    public Object size(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    @Override
    public Object multiGet(String key, Collection<String> hashKeys) {
        return redisTemplate.opsForHash().multiGet(key, hashKeys);
    }
}
