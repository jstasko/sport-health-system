package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity.Treatment;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.repository.TreatmentDao;

@Service
public class TreatmentServiceImpl extends CrudServiceImpl<Treatment, Integer, TreatmentDao> implements TreatmentService {

    public TreatmentServiceImpl(TreatmentDao dao) {
        super(dao);
    }
}
