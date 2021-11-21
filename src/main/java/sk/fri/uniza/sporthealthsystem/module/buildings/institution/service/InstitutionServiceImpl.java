package sk.fri.uniza.sporthealthsystem.module.buildings.institution.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.repository.InstitutionDao;

@Service
public class InstitutionServiceImpl extends CrudServiceImpl<Institution, Integer, InstitutionDao> implements InstitutionService {

    public InstitutionServiceImpl(InstitutionDao dao) {
        super(dao);
    }
}
