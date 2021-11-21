package sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.dto.ApothecaryDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.entity.Apothecary;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApothecaryDaoImpl extends CrudDaoImpl<Apothecary, ApothecaryDto, Integer, ApothecaryRepository> implements ApothecaryDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public ApothecaryDaoImpl(ApothecaryRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Apothecary findOne(Integer id) {
        ApothecaryDto apothecaryDto = this.findById(id);
        return this.mapper.map(apothecaryDto, Apothecary.class);
    }

    @Override
    public List<Apothecary> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Apothecary.class))
                .collect(Collectors.toList());
    }

    @Override
    public Apothecary save(Apothecary doc) {
        ApothecaryDto apothecaryDto = this.mapper.map(doc, ApothecaryDto.class);
        ApothecaryDto newApothecaryDto = this.repository.save(apothecaryDto);
        return this.mapper.map(newApothecaryDto, Apothecary.class);
    }
}
