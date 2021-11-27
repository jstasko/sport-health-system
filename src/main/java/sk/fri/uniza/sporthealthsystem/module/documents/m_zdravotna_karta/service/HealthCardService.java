package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.service;

import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;

public interface HealthCardService {
    HealthCard findOne(Long id);
    HealthCard save(HealthCard doc);
    void deleteById(Long id);
    HealthCard update(Long id, HealthCard doc);
}
