package sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.repository.ApothecaryDao;

@Service
public class ApothecaryServiceImpl extends CrudServiceImpl<Apothecary, Integer, ApothecaryDao> implements ApothecaryService {

    public ApothecaryServiceImpl(ApothecaryDao dao) {
        super(dao);
    }
}
