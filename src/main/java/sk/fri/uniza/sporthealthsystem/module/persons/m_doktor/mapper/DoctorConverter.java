package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DoctorConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Doctor.class, DoctorDto.class, oneWay())
                .fields("person", "person")
                .fields("image", "image")
                .fields("meno", "meno")
                .fields("priezvisko", "priezvisko")
                .fields("id", "id");

        mapping(DoctorDto.class, Doctor.class, oneWay())
                .fields("person", "person")
                .fields("image", "image")
                .fields("meno", "meno")
                .fields("priezvisko", "priezvisko")
                .fields("id", "id");
    }
}
