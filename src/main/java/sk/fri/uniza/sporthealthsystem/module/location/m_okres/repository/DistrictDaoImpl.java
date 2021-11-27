package sk.fri.uniza.sporthealthsystem.module.location.m_okres.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto.CountryDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto.DistrictDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity.District;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictDaoImpl extends CrudDaoImpl<District, DistrictDto, Integer, DistrictRepository> implements DistrictDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DistrictDaoImpl(DistrictRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public District findOne(Integer id) {
        DistrictDto districtDto = this.findById(id);
        return this.mapper.map(districtDto, District.class);
    }

    @Override
    public ListingResponse<District> findAll(Pageable pageable) {
        Page<DistrictDto> page =  this.findAllEntities(pageable);
        List<District> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, District.class))
                .collect(Collectors.toList());

        ListingResponse<District> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public District save(District doc) {
        DistrictDto districtDto = this.mapper.map(doc, DistrictDto.class);
        DistrictDto newDistrictDto = this.repository.save(districtDto);
        return this.mapper.map(newDistrictDto, District.class);
    }
}
