package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.repository;

import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;

public interface HealthCardDao {
    HealthCard findOne(Long id);
    HealthCard save(HealthCard doc);
    void deleteById(Long id);
    HealthCard update(Long id, HealthCard doc);
}
