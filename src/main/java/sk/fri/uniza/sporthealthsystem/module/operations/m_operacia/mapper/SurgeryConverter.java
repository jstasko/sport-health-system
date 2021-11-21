package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto.SurgeryDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class SurgeryConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Surgery.class, SurgeryDto.class, oneWay())
                .fields("id", "id")
                .fields("popis", "popis")
                .fields("nazov", "nazov");

        mapping(SurgeryDto.class, Surgery.class, oneWay())
                .fields("id", "id")
                .fields("popis", "popis")
                .fields("nazov", "nazov");
    }
}
