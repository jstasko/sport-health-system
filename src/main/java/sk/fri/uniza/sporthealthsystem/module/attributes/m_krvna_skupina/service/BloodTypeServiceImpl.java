package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.repository.BloodTypeDao;

@Service
public class BloodTypeServiceImpl implements BloodTypeService {

    private final BloodTypeDao bloodTypeDao;

    @Autowired
    public BloodTypeServiceImpl(BloodTypeDao dao) {
        this.bloodTypeDao = dao;
    }


    @Override
    public BloodType findOne(Long id) {
        return this.bloodTypeDao.findOne(id);
    }

    @Override
    public BloodType save(BloodType doc) {
        return this.bloodTypeDao.save(doc);
    }

    @Override
    public void deleteById(Long id) {
        this.bloodTypeDao.deleteById(id);
    }

    @Override
    public BloodType update(Long id, BloodType doc) {
        return this.bloodTypeDao.update(id, doc);
    }
}
