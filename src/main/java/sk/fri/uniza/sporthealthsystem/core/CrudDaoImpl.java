package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class CrudDaoImpl<T, U, I, R extends AbstractRepository<U, I>> implements CrudDao<T, I> {

    protected R repository;

    public CrudDaoImpl(R repository) {

        this.repository = repository;
    }

    @Override
    public void delete(I id) {
        this.repository.deleteById(id);
    }

    @Override
    public T findOne(I id) {
        return null;
    }

    @Override
    public ListingResponse<T> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public T save(T doc) {
        return null;
    }

    public U findById(I id) throws NotFoundException {
        return this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Object not found with id " + id));
    }

    public Page<U> findAllEntities(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
