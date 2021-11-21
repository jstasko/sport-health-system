package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto.DrugDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DrugConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Drug.class, DrugDto.class, oneWay())
                .fields("id", "id")
                .fields("vyrobca_liekov", "vyrobca_liekov")
                .fields("nazov", "nazov")
                .fields("popis", "popis");

        mapping(DrugDto.class, Drug.class, oneWay())
                .fields("id", "id")
                .fields("vyrobca_liekov", "vyrobca_liekov")
                .fields("nazov", "nazov")
                .fields("popis", "popis");
    }
}
