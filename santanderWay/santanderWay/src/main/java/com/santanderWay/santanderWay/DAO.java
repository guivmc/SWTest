package com.santanderWay.santanderWay;

public interface DAO<T>
{
    void save(T t);
    void update(T t);
    void delete(Integer id);
    T serarch(Integer id);
    void close();
}
