package sk.fri.uniza.sporthealthsystem.module.healthCard.repository;

import org.springframework.data.repository.CrudRepository;
import sk.fri.uniza.sporthealthsystem.module.healthCard.dto.HealthCardDto;

public interface HealthCardRepository extends CrudRepository<HealthCardDto, Long> {
}
