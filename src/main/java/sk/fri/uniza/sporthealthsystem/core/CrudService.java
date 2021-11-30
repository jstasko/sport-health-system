package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService<T, U> {
    T findOne(U id);
    ListingResponse<T> findAll(Pageable pageable);
    T save(T t);
    void deleteById(U id);
    T updateOne(U id, T body);
}
