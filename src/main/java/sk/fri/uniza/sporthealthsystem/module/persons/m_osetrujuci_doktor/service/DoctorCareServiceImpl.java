package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.repository.DoctorCareDao;

@Service
public class DoctorCareServiceImpl extends CrudServiceImpl<DoctorCare, Long, DoctorCareDao> implements DoctorCareService {

    public DoctorCareServiceImpl(DoctorCareDao dao) {
        super(dao);
    }

    @Override
    public DoctorCare updateOne(Long id, DoctorCare body) {
        DoctorCare foundOne = this.findOne(id);
        foundOne.setDoctor(body.getDoctor());
        foundOne.setInstitution(body.getInstitution());
        return this.dao.save(foundOne);
    }
}
