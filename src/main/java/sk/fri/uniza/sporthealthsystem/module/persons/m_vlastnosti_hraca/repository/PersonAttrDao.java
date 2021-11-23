package sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.repository;

import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity.PersonAttrType;

public interface PersonAttrDao {
    PersonAttrType findOne(Long id);
    PersonAttrType save(PersonAttrType doc);
    void deleteById(Long id);
    PersonAttrType update(Long id, PersonAttrType doc);
}
