package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto.AssuranceDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.entity.Assurance;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class AssuranceConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Assurance.class, AssuranceDto.class, oneWay())
                .fields("id", "id")
                .fields("nazov", "nazov")
                .fields("persons", "persons");

        mapping(AssuranceDto.class, Assurance.class, oneWay())
                .fields("id", "id")
                .fields("nazov", "nazov")
                .fields("persons", "persons");
    }
}
