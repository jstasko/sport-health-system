package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;

@Repository
public interface DoctorRepository extends AbstractRepository<DoctorDto, String> {
}
