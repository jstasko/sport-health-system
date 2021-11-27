package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.dto.DrugMakerDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.entity.DrugMaker;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DrugMakerConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(DrugMaker.class, DrugMakerDto.class, oneWay())
                .fields("id", "id")
                .fields("psc", "psc")
                .fields("nazov", "nazov");

        mapping(DrugMakerDto.class, DrugMaker.class, oneWay())
                .fields("id", "id")
                .fields("psc", "psc")
                .fields("nazov", "nazov");
    }
}
