package sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.dto.PacientOperationDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.entity.PacientOperation;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class PacientOperationConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(PacientOperation.class, PacientOperationDto.class, oneWay())
                .fields("id", "id")
                .fields("doctorCare", "doctorCare")
                .fields("person", "person")
                .fields("surgery", "surgery")
                .fields("popis", "popis");

        mapping(PacientOperationDto.class, PacientOperation.class, oneWay())
                .fields("id", "id")
                .fields("doctorCare", "doctorCare")
                .fields("person", "person")
                .fields("surgery", "surgery")
                .fields("popis", "popis");
    }
}
