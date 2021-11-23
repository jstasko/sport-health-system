package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.service.PersonService;

@RestController
@RequestMapping("/api/persons/persons")
public class PersonController extends CrudController<Person, String, PersonService> {

    @Autowired
    public PersonController(PersonService personService) {
        super(personService);
    }
}
