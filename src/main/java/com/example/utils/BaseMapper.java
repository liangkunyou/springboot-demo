package com.example.utils;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * BaseMapper 通用Mapper
 *
 * @author yezw1506
 * @date 2019-02-27
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
