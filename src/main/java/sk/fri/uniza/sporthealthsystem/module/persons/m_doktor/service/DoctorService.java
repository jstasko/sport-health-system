package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.service;

import org.springframework.data.domain.Pageable;
import sk.fri.uniza.sporthealthsystem.core.CrudService;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.ResponseDoctor;

public interface DoctorService extends CrudService<Doctor, String> {
    ListingResponse<ResponseDoctor> findALlWithRodCislo(Pageable pageable);
    ResponseDoctor findOneWithRodCislo(String id);
}
