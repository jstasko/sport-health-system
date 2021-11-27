package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto.DrugDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DrugDaoImpl extends CrudDaoImpl<Drug, DrugDto, Integer, DrugRepository> implements DrugDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DrugDaoImpl(DrugRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Drug findOne(Integer id) {
        DrugDto drugDto = this.findById(id);
        return this.mapper.map(drugDto, Drug.class);
    }

    @Override
    public List<Drug> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Drug.class))
                .collect(Collectors.toList());
    }

    @Override
    public Drug save(Drug doc) {
        DrugDto drugDto = this.mapper.map(doc, DrugDto.class);
        DrugDto newDrugDto = this.repository.save(drugDto);
        return this.mapper.map(newDrugDto, Drug.class);
    }
}
