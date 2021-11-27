package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.core.AbstractRepository;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;

@Repository
public interface AddressRepository extends AbstractRepository<AddressDto, String> {
}
