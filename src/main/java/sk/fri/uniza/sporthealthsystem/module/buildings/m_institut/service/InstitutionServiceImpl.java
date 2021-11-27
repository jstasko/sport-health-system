package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.repository.InstitutionDao;

@Service
public class InstitutionServiceImpl extends CrudServiceImpl<Institution, Integer, InstitutionDao> implements InstitutionService {

    public InstitutionServiceImpl(InstitutionDao dao) {
        super(dao);
    }

    @Override
    public Institution updateOne(Integer id, Institution body) {
        Institution foundOne = this.findOne(id);
        foundOne.setPsc(body.getPsc());
        foundOne.setNazov(body.getNazov());
        foundOne.setPopis(body.getPopis());
        return this.dao.save(foundOne);
    }
}
