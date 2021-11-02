package sk.fri.uniza.sporthealthsystem.core;

import java.util.List;

public abstract class CrudServiceImpl<T, D extends CrudDao<T>> implements CrudService<T> {

    protected D dao;

    public CrudServiceImpl(D dao) {
        this.dao = dao;
    }

    @Override
    public T findOne(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public T save(T t) {
        return dao.save(t);
    }
}
