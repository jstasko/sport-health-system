package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.service.FileMediaService;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.ResponseDoctor;
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

    @Override
    public ListingResponse<ResponseDoctor> findALlWithRodCislo(Pageable pageable) {
       return this.dao.findALlWithRodCislo(pageable);
    }

    @Override
    public ResponseDoctor findOneWithRodCislo(String id) {
        return this.dao.findOneWithRodCislo(id);
    }
}
