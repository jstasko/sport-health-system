package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto.HealthRecordDto;

@Repository
public interface HealthRecordRepository extends CrudRepository<HealthRecordDto, Long> {
}
