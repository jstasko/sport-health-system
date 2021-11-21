package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;

@Repository
public interface TreatmentRepository extends CrudRepository<TreatmentDto, Integer> {
}
