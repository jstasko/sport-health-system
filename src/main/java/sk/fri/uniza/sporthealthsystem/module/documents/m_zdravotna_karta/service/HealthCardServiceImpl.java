package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundIdInObject;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.repository.HealthCardDao;

import java.util.List;

@Service
public class HealthCardServiceImpl implements HealthCardService {

    private final HealthCardDao healthCardDao;

    @Autowired
    public HealthCardServiceImpl(HealthCardDao dao) {
        this.healthCardDao = dao;
    }


    @Override
    public List<HealthCard> findAll() {
        return this.healthCardDao.findAll();
    }

    @Override
    public HealthCard findOne(Long id) {
        return this.healthCardDao.findOne(id);
    }

    @Override
    public HealthCard save(HealthCard doc, List<Sickness> sicknesses) {
        HealthCard healthCard = this.healthCardDao.save(doc);

        if (healthCard.getId() == null) {
            throw new NotFoundIdInObject("Health card has no id");
        }

        List<Sickness> newSicknesses = this.healthCardDao.saveSickness(sicknesses, healthCard.getId());
        healthCard.setSicknesses(newSicknesses);
        return healthCard;
    }

    @Override
    public void deleteById(Long id) {
        this.healthCardDao.deleteById(id);
    }

    @Override
    public void deleteSicknessById(Long id, String sicknessId) {
        this.healthCardDao.deleteSicknessById(id, sicknessId);
    }

    // TODO vytiahnut vsetky sickness
    @Override
    public HealthCard update(Long id, HealthCard doc) {
        return this.healthCardDao.update(id, doc);
    }

    // TODO vytiahnut card
    @Override
    public HealthCard updateSickness(Long id, Sickness sickness) {
        return this.healthCardDao.updateSickness(id, sickness);
    }
}
