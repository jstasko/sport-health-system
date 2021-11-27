package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.repository.HealthRecordDao;

@Service
public class HealthRecordServiceImpl extends CrudServiceImpl<HealthRecord, Long, HealthRecordDao> implements HealthRecordService {

    public HealthRecordServiceImpl(HealthRecordDao dao) {
        super(dao);
    }

    @Override
    public HealthRecord updateOne(Long id, HealthRecord body) {
        HealthRecord foundOne = this.findOne(id);
        foundOne.setDoctor(body.getDoctor());
        foundOne.setDatum_prehliadky(body.getDatum_prehliadky());
        foundOne.setPerson(body.getPerson());
        foundOne.setInstitution(body.getInstitution());
        foundOne.setStav(body.getStav());
        return this.dao.save(foundOne);
    }
}
