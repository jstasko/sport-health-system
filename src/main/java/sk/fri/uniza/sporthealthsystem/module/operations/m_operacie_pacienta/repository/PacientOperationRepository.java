package sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.dto.PacientOperationDto;

@Repository
public interface PacientOperationRepository extends AbstractRepository<PacientOperationDto, Long> {
}
