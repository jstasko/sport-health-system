package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto.SurgeryDto;

@Repository
public interface SurgeryRepository extends AbstractRepository<SurgeryDto, Integer> {
}
