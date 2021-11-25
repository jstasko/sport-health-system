package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.repository.HealthCardDao;

@Service
public class HealthCardServiceImpl implements HealthCardService {

    private final HealthCardDao healthCardDao;

    @Autowired
    public HealthCardServiceImpl(HealthCardDao dao) {
        this.healthCardDao = dao;
    }


    @Override
    public HealthCard findOne(Long id) {
        return this.healthCardDao.findOne(id);
    }

    @Override
    public HealthCard save(HealthCard doc) {
        return this.healthCardDao.save(doc);
    }

    @Override
    public void deleteById(Long id) {
        this.healthCardDao.deleteById(id);
    }

    @Override
    public HealthCard update(Long id, HealthCard doc) {
        return this.healthCardDao.update(id, doc);
    }
}
