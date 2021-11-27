package sk.fri.uniza.sporthealthsystem.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class CrudServiceImpl<T, U, D extends CrudDao<T, U>> implements CrudService<T, U> {

    protected D dao;

    public CrudServiceImpl(D dao) {
        this.dao = dao;
    }

    @Override
    public void deleteById(U id) {
        dao.delete(id);
    }

    @Override
    public T findOne(U id) {
        return dao.findOne(id);
    }

    @Override
    public ListingResponse<T> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public T save(T t) {
        return dao.save(t);
    }
}
