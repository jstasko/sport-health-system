package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto.DocSpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.entity.DocSpecialization;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DocSpecializationConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(DocSpecialization.class, DocSpecializationDto.class, oneWay())
                .fields("id", "id")
                .fields("doc", "doc")
                .fields("specialization", "specialization");

        mapping(DocSpecializationDto.class, DocSpecialization.class, oneWay())
                .fields("id", "id")
                .fields("doc", "doc")
                .fields("specialization", "specialization");
    }
}
