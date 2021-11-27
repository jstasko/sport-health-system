package sk.fri.uniza.sporthealthsystem.module.location.m_okres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto.DistrictDto;

@Repository
public interface DistrictRepository extends CrudRepository<DistrictDto, Integer> {
}
