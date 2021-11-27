package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerDto, String> {
}
