package sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.entity.PacientOperation;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.repository.PacientOperationDao;

@Service
public class PacientOperationServiceImpl extends CrudServiceImpl<PacientOperation, Long, PacientOperationDao> implements PacientOperationService {

    public PacientOperationServiceImpl(PacientOperationDao dao) {
        super(dao);
    }
}
