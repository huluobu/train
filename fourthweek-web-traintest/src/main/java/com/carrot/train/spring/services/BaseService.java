package com.carrot.train.spring.services;

/**
 * @description:
 * @author: Lance
 * @create: 2020-09-19
 **/
public interface BaseService {
    /**
     * 修改
     * @param object
     */
    void update(Object object);

    /**
     * 新增
     * @param object
     */
    void insert(Object object);

    /**
     * 根据主键查询
     * @param primaryKey
     * @return
     */
    Object findByPrimaryKey(Object primaryKey);
}
