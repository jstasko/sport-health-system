package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto.DoctorCareDto;

@Repository
public interface DoctorCareRepository extends CrudRepository<DoctorCareDto, Long> {
}
