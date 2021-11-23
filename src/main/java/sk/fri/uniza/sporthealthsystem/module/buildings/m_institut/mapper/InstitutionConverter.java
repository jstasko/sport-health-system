package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class InstitutionConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Institution.class, InstitutionDto.class, oneWay())
                .fields("id", "id")
                .fields("psc", "psc")
                .fields("nazov", "nazov")
                .fields("popis", "popis");

        mapping(InstitutionDto.class, Institution.class, oneWay())
                .fields("id", "id")
                .fields("psc", "psc")
                .fields("nazov", "nazov")
                .fields("popis", "popis");
    }
}
