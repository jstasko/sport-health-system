package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto.DoctorCareDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;
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
    public ListingResponse<Person> findAll(Pageable pageable) {
        Page<PersonDto> page =  this.findAllEntities(pageable);
        List<Person> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Person.class))
                .collect(Collectors.toList());

        ListingResponse<Person> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Person save(Person doc) {
        PersonDto personDto = this.mapper.map(doc, PersonDto.class);
        PersonDto newPersonDto = this.repository.save(personDto);
        return this.mapper.map(newPersonDto, Person.class);
    }
}
