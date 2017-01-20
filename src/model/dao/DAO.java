package model.dao;

/**
 * Created by Vlad on 04.12.2016.
 */
public interface DAO<T>{
    void create(T t);
    T get(int id);
    boolean update(T t);
    boolean delete(int id);

}
