package sk.fri.uniza.sporthealthsystem.module.persons.player.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.persons.player.dto.PlayerDto;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerDto, Integer> {
}
