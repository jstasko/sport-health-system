package sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.dto.ApothecaryDto;

@Repository
public interface ApothecaryRepository extends AbstractRepository<ApothecaryDto, Integer> {
}
