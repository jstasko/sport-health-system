package sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.dto.ApothecaryDto;

@Repository
public interface ApothecaryRepository extends CrudRepository<ApothecaryDto, Integer> {
}
