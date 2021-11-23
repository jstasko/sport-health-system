package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstitutionDaoImpl extends CrudDaoImpl<Institution, InstitutionDto, Integer, InstitutionRepository> implements InstitutionDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public InstitutionDaoImpl(InstitutionRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Institution findOne(Integer id) {
        InstitutionDto institutionDto = this.findById(id);
        return this.mapper.map(institutionDto, Institution.class);
    }

    @Override
    public List<Institution> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Institution.class))
                .collect(Collectors.toList());
    }

    @Override
    public Institution save(Institution doc) {
        InstitutionDto institutionDto = this.mapper.map(doc, InstitutionDto.class);
        InstitutionDto newInstitutionDto = this.repository.save(institutionDto);
        return this.mapper.map(newInstitutionDto, Institution.class);
    }
}
