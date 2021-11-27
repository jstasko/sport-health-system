package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.repository.PersonDao;

@Service
public class PersonServiceImpl extends CrudServiceImpl<Person, String, PersonDao> implements PersonService {

    public PersonServiceImpl(PersonDao dao) {
        super(dao);
    }
}
