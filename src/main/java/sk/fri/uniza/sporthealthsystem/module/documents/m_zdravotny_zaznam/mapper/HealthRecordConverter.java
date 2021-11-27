package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import sk.fri.uniza.sporthealthsystem.core.mapper.InstantConverter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto.HealthRecordDto;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

import java.time.Instant;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class HealthRecordConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(HealthRecord.class, HealthRecordDto.class, oneWay())
                .fields("id", "id")
                .fields("doctor", "doctor")
                .fields("person", "person")
                .fields("datum_prehliadky", "datum_prehliadky", FieldsMappingOptions.customConverter(InstantConverter.class))
                .fields("stav", "stav")
                .fields("institution", "institution");

        mapping(HealthRecordDto.class, HealthRecord.class, oneWay())
                .fields("id", "id")
                .fields("doctor", "doctor")
                .fields("person", "person")
                .fields("datum_prehliadky", "datum_prehliadky", FieldsMappingOptions.customConverter(InstantConverter.class))
                .fields("stav", "stav")
                .fields("institution", "institution");
    }
}
