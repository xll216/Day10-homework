package com.lanou.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface BaseDao<T> {
    T findById(Class<T> tClass,Serializable id);

    List<T> findAll(String hql);

    List<T> find(String hql, Map<String, Object> params);
}
