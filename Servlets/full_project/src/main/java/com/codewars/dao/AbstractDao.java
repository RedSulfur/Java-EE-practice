package com.codewars.dao;

import java.util.List;

/**
 * Created by sulfur on 21.03.16.
 */
public interface AbstractDao<T> {

    public T create(T entity);
    public void delete(T entity);
    public T edit (T entity);
    public T getById(Integer id);
    public List<T> getAll();
}
