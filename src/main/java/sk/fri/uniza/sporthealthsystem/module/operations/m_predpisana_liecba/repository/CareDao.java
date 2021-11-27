package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.repository;

import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity.Care;

public interface CareDao {
    Care findOne(Long id);
    Care save(Care doc);
    void deleteById(Long id);
    Care update(Long id, Care doc);
}
