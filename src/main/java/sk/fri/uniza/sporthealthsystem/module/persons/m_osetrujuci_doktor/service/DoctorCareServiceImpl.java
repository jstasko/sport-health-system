package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.repository.DoctorCareDao;

@Service
public class DoctorCareServiceImpl extends CrudServiceImpl<DoctorCare, Long, DoctorCareDao> implements DoctorCareService {

    public DoctorCareServiceImpl(DoctorCareDao dao) {
        super(dao);
    }
}
