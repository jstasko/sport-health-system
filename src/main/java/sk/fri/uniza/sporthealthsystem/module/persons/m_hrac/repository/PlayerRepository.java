package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;

import java.util.List;

@Repository
public interface PlayerRepository extends AbstractRepository<PlayerDto, String> { }
