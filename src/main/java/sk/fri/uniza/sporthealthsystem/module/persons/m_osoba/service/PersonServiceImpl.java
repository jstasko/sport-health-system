package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.service;

import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.repository.PersonDao;

@Service
public class PersonServiceImpl extends CrudServiceImpl<Person, String, PersonDao> implements PersonService {

    public PersonServiceImpl(PersonDao dao) {
        super(dao);
    }

    @Override
    public Person updateOne(String id, Person body) {
        Person foundOne = this.findOne(id);
        foundOne.setEmail(body.getEmail());
        foundOne.setExterneId(body.getExterneId());
        return this.dao.save(foundOne);
    }
}
