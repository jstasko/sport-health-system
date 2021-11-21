package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.dto.DrugMakerDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.entity.DrugMaker;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DrugMakerDaoImpl extends CrudDaoImpl<DrugMaker, DrugMakerDto, Integer, DrugMakerRepository> implements DrugMakerDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DrugMakerDaoImpl(DrugMakerRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public DrugMaker findOne(Integer id) {
        DrugMakerDto drugMakerDto = this.findById(id);
        return this.mapper.map(drugMakerDto, DrugMaker.class);
    }

    @Override
    public List<DrugMaker> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, DrugMaker.class))
                .collect(Collectors.toList());
    }

    @Override
    public DrugMaker save(DrugMaker doc) {
        DrugMakerDto drugMakerDto = this.mapper.map(doc, DrugMakerDto.class);
        DrugMakerDto newDrugMakerDto = this.repository.save(drugMakerDto);
        return this.mapper.map(newDrugMakerDto, DrugMaker.class);
    }
}
