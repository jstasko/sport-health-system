package sk.fri.uniza.sporthealthsystem.module.location.m_kraj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto.RegionDto;

@Repository
public interface RegionRepository extends CrudRepository<RegionDto, String> {
}
