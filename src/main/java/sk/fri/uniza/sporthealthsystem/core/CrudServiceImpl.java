package sk.fri.uniza.sporthealthsystem.core;

import java.util.List;

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
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public T save(T t) {
        return dao.save(t);
    }
}
