package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto.AssuranceDto;

@Repository
public interface AssuranceRepository extends AbstractRepository<AssuranceDto, Integer> {
}
