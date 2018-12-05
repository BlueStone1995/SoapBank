package main.java.dao;

import java.util.List;

public interface DAO<T> {

    T find(int id);

    List<T> findAll();

    T create(T obj);

    T update(T obj);

    void delete(T obj);
}
