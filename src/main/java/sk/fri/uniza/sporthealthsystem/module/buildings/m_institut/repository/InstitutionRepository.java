package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;

@Repository
public interface InstitutionRepository extends CrudRepository<InstitutionDto, Integer> {
}
