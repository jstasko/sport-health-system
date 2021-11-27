package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto.DocSpecializationDto;

@Repository
public interface DocSpecializationRepository extends AbstractRepository<DocSpecializationDto, Long> {
}
