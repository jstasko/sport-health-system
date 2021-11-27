package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto.SurgeryDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurgeryDaoImpl extends CrudDaoImpl<Surgery, SurgeryDto, Integer, SurgeryRepository> implements SurgeryDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public SurgeryDaoImpl(SurgeryRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Surgery findOne(Integer id) {
        SurgeryDto surgeryDto = this.findById(id);
        return this.mapper.map(surgeryDto, Surgery.class);
    }

    @Override
    public List<Surgery> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Surgery.class))
                .collect(Collectors.toList());
    }

    @Override
    public Surgery save(Surgery doc) {
        SurgeryDto surgeryDto = this.mapper.map(doc, SurgeryDto.class);
        SurgeryDto newSurgeryDto = this.repository.save(surgeryDto);
        return this.mapper.map(newSurgeryDto, Surgery.class);
    }
}
