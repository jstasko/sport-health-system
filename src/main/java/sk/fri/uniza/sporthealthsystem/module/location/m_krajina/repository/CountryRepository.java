package sk.fri.uniza.sporthealthsystem.module.location.m_krajina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto.CountryDto;

@Repository
public interface CountryRepository extends AbstractRepository<CountryDto, String> {
}
