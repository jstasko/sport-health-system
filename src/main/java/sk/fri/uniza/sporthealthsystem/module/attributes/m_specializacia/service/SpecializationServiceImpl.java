package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity.PlayerAddress;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.repository.SpecializationDao;

@Service
public class SpecializationServiceImpl extends CrudServiceImpl<Specialization, Integer, SpecializationDao> implements SpecializationService {

    public SpecializationServiceImpl(SpecializationDao dao) {
        super(dao);
    }

    @Override
    public Specialization updateOne(Integer id, Specialization body) {
        Specialization foundOne = this.findOne(id);
        foundOne.setNazov(body.getNazov());
        foundOne.setPopis(body.getPopis());
        return this.dao.save(foundOne);
    }
}
