package sk.fri.uniza.sporthealthsystem.core;

import java.util.List;

public interface CrudService<T> {
    T findOne(Long id);
    List<T> findAll();
    T save(T t);
}
