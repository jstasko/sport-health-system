package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class PersonConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Person.class, PersonDto.class, oneWay())
                .fields("rodCislo", "rodCislo")
                .fields("externeId", "externeId")
                .fields("email", "email");

        mapping(PersonDto.class, Person.class, oneWay())
                .fields("rodCislo", "rodCislo")
                .fields("externeId", "externeId")
                .fields("email", "email");
    }
}
