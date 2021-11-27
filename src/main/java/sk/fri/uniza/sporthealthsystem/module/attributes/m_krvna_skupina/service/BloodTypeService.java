package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.service;

import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;

public interface BloodTypeService {
    BloodType findOne(Long id);
    BloodType save(BloodType doc);
    void deleteById(Long id);
    BloodType update(Long id, BloodType doc);
}
