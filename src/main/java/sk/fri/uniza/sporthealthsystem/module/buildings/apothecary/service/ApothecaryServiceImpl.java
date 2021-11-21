package sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.repository.ApothecaryDao;

@Service
public class ApothecaryServiceImpl extends CrudServiceImpl<Apothecary, Integer, ApothecaryDao> implements ApothecaryService {

    public ApothecaryServiceImpl(ApothecaryDao dao) {
        super(dao);
    }
}
