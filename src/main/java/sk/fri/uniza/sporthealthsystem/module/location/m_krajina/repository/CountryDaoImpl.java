package sk.fri.uniza.sporthealthsystem.module.location.m_krajina.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
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
    public List<Country> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Country.class))
                .collect(Collectors.toList());
    }

    @Override
    public Country save(Country doc) {
        CountryDto countryDto = this.mapper.map(doc, CountryDto.class);
        CountryDto newCountryDto = this.repository.save(countryDto);
        return this.mapper.map(newCountryDto, Country.class);
    }
}
