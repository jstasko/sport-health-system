package sk.fri.uniza.sporthealthsystem.module.location.m_kraj.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto.RegionDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto.CountryDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;

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
    public ListingResponse<Region> findAll(Pageable pageable) {
        Page<RegionDto> page =  this.findAllEntities(pageable);
        List<Region> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Region.class))
                .collect(Collectors.toList());

        ListingResponse<Region> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Region save(Region doc) {
        RegionDto regionDto = this.mapper.map(doc, RegionDto.class);
        RegionDto newRegionDto = this.repository.save(regionDto);
        return this.mapper.map(newRegionDto, Region.class);
    }
}
