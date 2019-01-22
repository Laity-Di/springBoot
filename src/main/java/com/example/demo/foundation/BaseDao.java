package com.example.demo.foundation;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: Ryan
 * @since: 2018/11/8 11:19
 * @description:
 * @modifyTime:
 * @modifier:
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {


}
