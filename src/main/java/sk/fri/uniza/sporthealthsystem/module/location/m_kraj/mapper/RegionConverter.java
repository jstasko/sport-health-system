package sk.fri.uniza.sporthealthsystem.module.location.m_kraj.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto.RegionDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class RegionConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Region.class, RegionDto.class, oneWay())
                .fields("id", "id")
                .fields("n_kraja", "n_kraja")
                .fields("country", "country");

        mapping(RegionDto.class, Region.class, oneWay())
                .fields("id", "id")
                .fields("n_kraja", "n_kraja")
                .fields("country", "country");
    }
}
