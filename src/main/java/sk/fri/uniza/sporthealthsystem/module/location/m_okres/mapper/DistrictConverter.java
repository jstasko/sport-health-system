package sk.fri.uniza.sporthealthsystem.module.location.m_okres.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto.DistrictDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity.District;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DistrictConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(District.class, DistrictDto.class, oneWay())
                .fields("id", "id")
                .fields("n_okresu", "n_okresu")
                .fields("region", "region");

        mapping(DistrictDto.class, District.class, oneWay())
                .fields("id", "id")
                .fields("n_okresu", "n_okresu")
                .fields("region", "region");
    }
}
