package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.repository.DoctorDao;

@Service
public class DoctorServiceImpl extends CrudServiceImpl<Doctor, Long, DoctorDao> implements DoctorService {

    public DoctorServiceImpl(DoctorDao dao) {
        super(dao);
    }
}
