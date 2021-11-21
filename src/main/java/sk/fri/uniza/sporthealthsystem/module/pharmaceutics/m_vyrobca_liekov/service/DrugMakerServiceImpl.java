package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.entity.DrugMaker;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.repository.DrugMakerDao;

@Service
public class DrugMakerServiceImpl extends CrudServiceImpl<DrugMaker, Integer, DrugMakerDao> implements DrugMakerService {

    public DrugMakerServiceImpl(DrugMakerDao dao) {
        super(dao);
    }
}
