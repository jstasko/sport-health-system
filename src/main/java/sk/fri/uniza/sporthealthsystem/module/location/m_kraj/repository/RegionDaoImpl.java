package sk.fri.uniza.sporthealthsystem.module.location.m_kraj.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto.RegionDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegionDaoImpl extends CrudDaoImpl<Region, RegionDto, String, RegionRepository> implements RegionDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public RegionDaoImpl(RegionRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Region findOne(String id) {
        RegionDto regionDto = this.findById(id);
        return this.mapper.map(regionDto, Region.class);
    }

    @Override
    public List<Region> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Region.class))
                .collect(Collectors.toList());
    }

    @Override
    public Region save(Region doc) {
        RegionDto regionDto = this.mapper.map(doc, RegionDto.class);
        RegionDto newRegionDto = this.repository.save(regionDto);
        return this.mapper.map(newRegionDto, Region.class);
    }
}
