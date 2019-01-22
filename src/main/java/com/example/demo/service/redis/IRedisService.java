package com.example.demo.service.redis;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: Ryan
 * @since: 2018/11/9 11:43
 * @description:
 * @modifyTime:
 * @modifier:
 */
public interface IRedisService {

    /*****************String*********************/
    /**
     * 设置指定键的值
     * @param key   键
     * @param value 值
     * @return
     */
    boolean set(String key, Object value);

    /**
     * 给已存在的键值设置有效期
     * @param key      键
     * @param timeout  过期时间
     * @param timeUnit 时间单位{@link TimeUnit }
     * @return
     */
    boolean set(String key, int timeout, TimeUnit timeUnit);

    /**
     * 设置指定键值并设置有效时间
     * @param key       键
     * @param value     值
     * @param timeout   有效期
     * @param timeUnit  时间单位{@link TimeUnit }
     * @return
     */
    boolean set(String key, Object value, int timeout, TimeUnit timeUnit);

    /**
     * 设置键的值，仅当键不存在时
     * @param key   键
     * @param value 值
     * @return
     */
    boolean setIfAbsent(String key, Object value);

    /**
     * 批量设置键值
     * @param map  即Map<key,value>
     * @return
     */
    boolean multiSet(Map<String, Object> map);

    /**
     * 设置键的值并返回其旧值
     * @param key   键
     * @param value 值
     * @return
     */
    Object getAndSet(String key, Object value);

    /**
     * 获取指定键的值
     * @param key 键
     * @return
     */
    Object get(String key);

    /**
     * 删除指定键值
     * @param key 键
     * @return
     */
    boolean delete(String key);

    /*****************************hash*********************************/
    /**
     * 设置散列字段的字符串值
     * hash类型简单用法：key存放对象名，hashkey存放field即属性，value存放属性值，
     * 因此hash结构非常适合存放对象，而且hash类型比String更节省内存
     * @param key       键
     * @param hashKey   hash键
     * @param value     值
     * @return
     */
    boolean put(String key, String hashKey, Object value);

    /**
     * 当字段不存在时，才设置散列字段的值
     * @param key       键
     * @param hashKey   hash键
     * @param value     值
     * @return
     */
    boolean putIfAbsent(String key, String hashKey, Object value);

    /**
     * 批量添加hash字段以及值
     * @param key   键
     * @param map   hashKey和value的map
     * @return
     */
    boolean putAll(String key, Map<String, Object> map);

    /**
     * 判断是否存在散列字段
     * @param key
     * @param hashKey
     * @return
     */
    boolean hasKey(String key, String hashKey);

    /**
     * 获取存储在指定键的哈希字段的值
     * @param key
     * @param hashKey
     * @return
     */
    Object get(String key, String hashKey);

    /**
     * 获取存储在指定键的哈希中的所有字段和值
     * @param key
     * @return
     */
    Object entries(String key);

    /**
     * 删除一个或多个哈希字段
     * @param key
     * @param hashKeys
     * @return
     */
    boolean delete(String key, Object... hashKeys);

    /**
     * 获取哈希中的所有字段
     * @param key
     * @return
     */
    Object keys(String key);

    /**
     * 获取哈希中的所有值
     * @param key
     * @return
     */
    Object values(String key);

    /**
     * 获取散列中的字段数量
     * @param key
     * @return
     */
    Object size(String key);

    /**
     * 获取所有给定哈希字段的值
     * @param key
     * @param hashKeys
     * @return
     */
    Object multiGet(String key, Collection<String> hashKeys);
}
