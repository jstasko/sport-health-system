package sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.repository.ApothecaryDao;

@Service
public class ApothecaryServiceImpl extends CrudServiceImpl<Apothecary, Integer, ApothecaryDao> implements ApothecaryService {

    public ApothecaryServiceImpl(ApothecaryDao dao) {
        super(dao);
    }

    @Override
    public Apothecary updateOne(Integer id, Apothecary body) {
        Apothecary foundOne = this.findOne(id);
        foundOne.setPsc(body.getPsc());
        foundOne.setNazov(body.getNazov());
        foundOne.setPsc(body.getPsc());
        return this.dao.save(foundOne);
    }
}
