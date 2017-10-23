package com.lanou.dao.impl;

import com.lanou.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    @Override
    public T findById(Class<T> tClass, Serializable id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        T t = session.get(tClass, id);

        transaction.commit();
        return t;
    }

    @Override
    public List<T> findAll(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(hql);
        List<T> tList = query.list();

        transaction.commit();
        return tList;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }

        List<T> tList = query.list();

        transaction.commit();
        return tList;
    }
}
