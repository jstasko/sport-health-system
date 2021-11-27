package sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.dto.ApothecaryDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.entity.Apothecary;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class ApothecaryConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Apothecary.class, ApothecaryDto.class, oneWay())
                .fields("id", "id")
                .fields("psc", "psc")
                .fields("nazov", "nazov");

        mapping(ApothecaryDto.class, Apothecary.class, oneWay())
                .fields("id", "id")
                .fields("psc", "psc")
                .fields("nazov", "nazov");
    }
}
