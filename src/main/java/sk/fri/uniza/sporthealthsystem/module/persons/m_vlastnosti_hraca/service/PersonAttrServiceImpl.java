package sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity.PersonAttrType;
import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.repository.PersonAttrDao;

@Service
public class PersonAttrServiceImpl implements PersonAttrService {

    private final PersonAttrDao personAttrDao;

    @Autowired
    public PersonAttrServiceImpl(PersonAttrDao dao) {
        this.personAttrDao = dao;
    }


    @Override
    public PersonAttrType findOne(Long id) {
        return this.personAttrDao.findOne(id);
    }

    @Override
    public PersonAttrType save(PersonAttrType doc) {
        return this.personAttrDao.save(doc);
    }

    @Override
    public void deleteById(Long id) {
        this.personAttrDao.deleteById(id);
    }

    @Override
    public PersonAttrType update(Long id, PersonAttrType doc) {
        return this.personAttrDao.update(id, doc);
    }
}
