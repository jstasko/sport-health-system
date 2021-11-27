package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.data.repository.CrudRepository;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class CrudDaoImpl<T, U, I, R extends CrudRepository<U, I>> implements CrudDao<T, I> {

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
    public List<T> findAll() {
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

    public List<U> findAllEntities() {
        List<U> newList = new ArrayList<>();
        this.repository.findAll()
                .forEach(newList::add);
        return newList;
    }
}
