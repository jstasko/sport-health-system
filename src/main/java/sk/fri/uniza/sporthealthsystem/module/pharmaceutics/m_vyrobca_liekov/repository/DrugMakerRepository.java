package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.dto.DrugMakerDto;

@Repository
public interface DrugMakerRepository extends AbstractRepository<DrugMakerDto, Integer> {
}
