package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity.Care;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.repository.CareDao;

@Service
public class CareServiceImpl implements CareService {

    private final CareDao careDao;

    @Autowired
    public CareServiceImpl(CareDao dao) {
        this.careDao = dao;
    }


    @Override
    public Care findOne(Long id) {
        return this.careDao.findOne(id);
    }

    @Override
    public Care save(Care doc) {
        return this.careDao.save(doc);
    }

    @Override
    public void deleteById(Long id) {
        this.careDao.deleteById(id);
    }

    @Override
    public Care update(Long id, Care doc) {
        return this.careDao.update(id, doc);
    }
}
