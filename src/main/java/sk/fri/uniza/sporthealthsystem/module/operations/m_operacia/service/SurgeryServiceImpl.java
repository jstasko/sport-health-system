package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity.Treatment;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.repository.SurgeryDao;

@Service
public class SurgeryServiceImpl extends CrudServiceImpl<Surgery, Integer, SurgeryDao> implements SurgeryService {

    public SurgeryServiceImpl(SurgeryDao dao) {
        super(dao);
    }

    @Override
    public Surgery updateOne(Integer id, Surgery body) {
        Surgery foundOne = this.findOne(id);
        foundOne.setNazov(body.getNazov());
        foundOne.setPopis(body.getPopis());
        return this.dao.save(foundOne);
    }
}
