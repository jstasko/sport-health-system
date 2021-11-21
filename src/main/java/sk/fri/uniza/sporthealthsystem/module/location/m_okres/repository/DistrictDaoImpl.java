package sk.fri.uniza.sporthealthsystem.module.location.m_okres.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto.DistrictDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity.District;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictDaoImpl extends CrudDaoImpl<District, DistrictDto, String, DistrictRepository> implements DistrictDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DistrictDaoImpl(DistrictRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public District findOne(String id) {
        DistrictDto districtDto = this.findById(id);
        return this.mapper.map(districtDto, District.class);
    }

    @Override
    public List<District> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, District.class))
                .collect(Collectors.toList());
    }

    @Override
    public District save(District doc) {
        DistrictDto districtDto = this.mapper.map(doc, DistrictDto.class);
        DistrictDto newDistrictDto = this.repository.save(districtDto);
        return this.mapper.map(newDistrictDto, District.class);
    }
}
