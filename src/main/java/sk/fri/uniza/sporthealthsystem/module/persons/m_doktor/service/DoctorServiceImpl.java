package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.repository.DoctorDao;

@Service
public class DoctorServiceImpl extends CrudServiceImpl<Doctor, String, DoctorDao> implements DoctorService {

    public DoctorServiceImpl(DoctorDao dao) {
        super(dao);
    }

    @Override
    public Doctor updateOne(String id, Doctor body) {
        Doctor foundOne = this.findOne(id);
        foundOne.setImage(body.getImage());
        foundOne.setMeno(body.getMeno());
        foundOne.setPerson(body.getPerson());
        foundOne.setPriezvisko(body.getPriezvisko());
        return this.dao.save(foundOne);
    }
}
