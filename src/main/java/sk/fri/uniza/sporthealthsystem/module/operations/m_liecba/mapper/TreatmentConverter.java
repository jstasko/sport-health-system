package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity.Treatment;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class TreatmentConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Treatment.class, TreatmentDto.class, oneWay())
                .fields("id", "id")
                .fields("cena", "cena")
                .fields("stav", "stav")
                .fields("apothecary", "apothecary")
                .fields("institution", "institution")
                .fields("drug", "drug");

        mapping(TreatmentDto.class, Treatment.class, oneWay())
                .fields("id", "id")
                .fields("cena", "cena")
                .fields("stav", "stav")
                .fields("apothecary", "apothecary")
                .fields("institution", "institution")
                .fields("drug", "drug");
    }
}
