package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto.DrugDto;

@Repository
public interface DrugRepository extends AbstractRepository<DrugDto, Integer> {
}
