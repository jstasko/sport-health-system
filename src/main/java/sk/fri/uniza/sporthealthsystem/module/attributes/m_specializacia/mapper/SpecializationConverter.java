package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto.SpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class SpecializationConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Specialization.class, SpecializationDto.class, oneWay())
                .fields("id", "id")
                .fields("popis", "popis")
                .fields("nazov", "nazov");

        mapping(SpecializationDto.class, Specialization.class, oneWay())
                .fields("id", "id")
                .fields("popis", "popis")
                .fields("nazov", "nazov");
    }
}
