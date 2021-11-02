package sk.fri.uniza.sporthealthsystem.core;

import org.dozer.DozerBeanMapper;
import org.springframework.data.repository.CrudRepository;
import sk.fri.uniza.sporthealthsystem.module.healthCard.dto.HealthCardDto;

import java.util.List;
import java.util.Optional;

public abstract class CrudDaoImpl<T, U extends BaseDocumentDto, R extends CrudRepository<U, Long>> implements CrudDao<T> {

    protected R repository;
    protected DozerBeanMapper mapper;

    public CrudDaoImpl(R repository, DozerBeanMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public T findOne(Long id) {
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
}
