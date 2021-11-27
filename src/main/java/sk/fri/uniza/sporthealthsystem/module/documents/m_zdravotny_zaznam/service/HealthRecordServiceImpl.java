package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.repository.HealthRecordDao;

@Service
public class HealthRecordServiceImpl extends CrudServiceImpl<HealthRecord, Long, HealthRecordDao> implements HealthRecordService {

    public HealthRecordServiceImpl(HealthRecordDao dao) {
        super(dao);
    }
}
