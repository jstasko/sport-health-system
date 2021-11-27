package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto.SpecializationDto;

@Repository
public interface SpecializationRepository extends CrudRepository<SpecializationDto, Integer> {
}
