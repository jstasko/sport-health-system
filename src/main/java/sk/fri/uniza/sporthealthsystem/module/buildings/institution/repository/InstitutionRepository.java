package sk.fri.uniza.sporthealthsystem.module.buildings.institution.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.dto.InstitutionDto;

@Repository
public interface InstitutionRepository extends CrudRepository<InstitutionDto, Integer> {
}
