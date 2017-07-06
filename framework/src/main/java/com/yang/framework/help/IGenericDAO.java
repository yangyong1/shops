package com.yang.framework.help;

import java.io.Serializable;

/**
 * Created by zen on 2015/1/2.
 */
public interface IGenericDAO<T,PK extends Serializable> {

    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public void deleteById(Class<T> entityClass, PK id);
    public void saveorupdate(T entity);
}
