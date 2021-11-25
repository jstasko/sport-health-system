package sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.dto.PlayerAddressDto;

@Repository
public interface PlayerAddressRepository extends CrudRepository<PlayerAddressDto, Long> {
}
