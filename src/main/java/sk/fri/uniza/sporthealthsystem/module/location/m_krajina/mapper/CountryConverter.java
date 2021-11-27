package sk.fri.uniza.sporthealthsystem.module.location.m_krajina.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto.CountryDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class CountryConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {


        mapping(Country.class, CountryDto.class, oneWay())
                .fields("id", "id")
                .fields("n_krajiny", "n_krajiny");

        mapping(CountryDto.class, Country.class, oneWay())
                .fields("id", "id")
                .fields("n_krajiny", "n_krajiny");
    }
}
