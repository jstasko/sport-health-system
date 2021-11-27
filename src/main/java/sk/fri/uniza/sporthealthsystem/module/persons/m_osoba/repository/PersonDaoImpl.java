package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonDaoImpl extends CrudDaoImpl<Person, PersonDto, String, PersonRepository> implements PersonDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public PersonDaoImpl(PersonRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Person findOne(String id) {
        PersonDto personDto = this.findById(id);
        return this.mapper.map(personDto, Person.class);
    }

    @Override
    public List<Person> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Person.class))
                .collect(Collectors.toList());
    }

    @Override
    public Person save(Person doc) {
        PersonDto personDto = this.mapper.map(doc, PersonDto.class);
        PersonDto newPersonDto = this.repository.save(personDto);
        return this.mapper.map(newPersonDto, Person.class);
    }
}
