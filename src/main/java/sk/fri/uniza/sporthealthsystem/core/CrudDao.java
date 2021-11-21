package sk.fri.uniza.sporthealthsystem.core;

import java.util.List;

public interface CrudDao<T, U> {
    T findOne(U id);
    List<T> findAll();
    T save(T t);
    void delete(U id);
}
