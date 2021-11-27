package sk.fri.uniza.sporthealthsystem.module.location.m_krajina.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto.HealthRecordDto;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto.CountryDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryDaoImpl extends CrudDaoImpl<Country, CountryDto, String, CountryRepository> implements CountryDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public CountryDaoImpl(CountryRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Country findOne(String id) {
        CountryDto countryDto = this.findById(id);
        return this.mapper.map(countryDto, Country.class);
    }

    @Override
    public ListingResponse<Country> findAll(Pageable pageable) {
        Page<CountryDto> page =  this.findAllEntities(pageable);
        List<Country> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Country.class))
                .collect(Collectors.toList());

        ListingResponse<Country> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Country save(Country doc) {
        CountryDto countryDto = this.mapper.map(doc, CountryDto.class);
        CountryDto newCountryDto = this.repository.save(countryDto);
        return this.mapper.map(newCountryDto, Country.class);
    }
}
