package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto.AssuranceDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.entity.Assurance;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssuranceDaoImpl extends CrudDaoImpl<Assurance, AssuranceDto, Integer, AssuranceRepository> implements AssuranceDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public AssuranceDaoImpl(AssuranceRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Assurance findOne(Integer id) {
        AssuranceDto assuranceDto = this.findById(id);
        return this.mapper.map(assuranceDto, Assurance.class);
    }

    @Override
    public List<Assurance> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Assurance.class))
                .collect(Collectors.toList());
    }

    @Override
    public Assurance save(Assurance doc) {
        AssuranceDto assuranceDto = this.mapper.map(doc, AssuranceDto.class);
        AssuranceDto newAssuranceDto = this.repository.save(assuranceDto);
        return this.mapper.map(newAssuranceDto, Assurance.class);
    }
}
