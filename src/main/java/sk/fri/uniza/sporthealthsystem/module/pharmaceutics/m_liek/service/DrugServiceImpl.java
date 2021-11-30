package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.repository.DrugDao;

@Service
public class DrugServiceImpl extends CrudServiceImpl<Drug, Integer, DrugDao> implements DrugService {

    public DrugServiceImpl(DrugDao dao) {
        super(dao);
    }

    @Override
    public Drug updateOne(Integer id, Drug body) {
        Drug foundOne = this.findOne(id);
        foundOne.setNazov(body.getNazov());
        foundOne.setPopis(body.getPopis());
        foundOne.setVyrobca_liekov(body.getVyrobca_liekov());
        return this.dao.save(foundOne);
    }
}
