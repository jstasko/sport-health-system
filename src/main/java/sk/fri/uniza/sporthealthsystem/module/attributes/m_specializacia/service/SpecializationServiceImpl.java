package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.repository.SpecializationDao;

@Service
public class SpecializationServiceImpl extends CrudServiceImpl<Specialization, Integer, SpecializationDao> implements SpecializationService {

    public SpecializationServiceImpl(SpecializationDao dao) {
        super(dao);
    }
}
