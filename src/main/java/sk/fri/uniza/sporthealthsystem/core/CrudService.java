package sk.fri.uniza.sporthealthsystem.core;

import java.util.List;

public interface CrudService<T, U> {
    T findOne(U id);
    List<T> findAll();
    T save(T t);
    void deleteById(U id);
}
