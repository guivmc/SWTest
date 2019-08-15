package com.santanderWay.santanderWay;

public interface DAO<T>
{
    void save(T t);
    void update(T t);
    void delete(String id);
    T serarch(String id);
    void close();
}
