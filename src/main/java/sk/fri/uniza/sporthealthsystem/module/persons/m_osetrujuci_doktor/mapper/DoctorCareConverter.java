package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto.DoctorCareDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class DoctorCareConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(DoctorCare.class, DoctorCareDto.class, oneWay())
                .fields("id", "id")
                .fields("institution", "institution")
                .fields("doctor", "doctor");

        mapping(DoctorCareDto.class, DoctorCare.class, oneWay())
                .fields("id", "id")
                .fields("institution", "institution")
                .fields("doctor", "doctor");
    }
}
