package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudDao<T, U> {
    T findOne(U id);
    ListingResponse<T> findAll(Pageable pageable);
    T save(T t);
    void delete(U id);
}
