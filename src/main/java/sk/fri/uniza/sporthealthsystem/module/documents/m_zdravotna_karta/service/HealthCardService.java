package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.service;

import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;

import java.util.List;

public interface HealthCardService {
    List<HealthCard> findAll();
    HealthCard findOne(Long id);
    HealthCard save(HealthCard doc, List<Sickness> sicknesses);
    void deleteById(Long id);
    void deleteSicknessById(Long id, String sicknessId);
    HealthCard update(Long id, HealthCard doc);
    HealthCard updateSickness(Long id, Sickness sickness);
}
