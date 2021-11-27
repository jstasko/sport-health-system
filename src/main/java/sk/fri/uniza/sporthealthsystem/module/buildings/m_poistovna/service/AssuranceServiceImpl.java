package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.entity.Assurance;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.repository.AssuranceDao;

@Service
public class AssuranceServiceImpl extends CrudServiceImpl<Assurance, Integer, AssuranceDao> implements AssuranceService {

    public AssuranceServiceImpl(AssuranceDao dao) {
        super(dao);
    }
}
