package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;

@Repository
public interface PersonRepository extends AbstractRepository<PersonDto, String> {
}
