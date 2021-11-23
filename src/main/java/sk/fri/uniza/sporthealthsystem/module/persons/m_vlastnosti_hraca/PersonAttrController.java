package sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity.Attributes;
import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity.PersonAttrType;
import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity.IncomingPersonAttr;
import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.service.PersonAttrService;

@RestController
@RequestMapping("/api/peresions/attributes")
public class PersonAttrController {

    PersonAttrService personAttrService;

    @Autowired
    public PersonAttrController(PersonAttrService personAttrService) {
        this.personAttrService = personAttrService;
    }

    @GetMapping("/{id}")
    public PersonAttrType findOne(
            @PathVariable("id") Long id
    ) {
        return this.personAttrService.findOne(id);
    }

    @PostMapping()
    public PersonAttrType save(
            @RequestBody IncomingPersonAttr personAttr
            ) {

        return this.personAttrService.save(
                new PersonAttrType(personAttr.getRodCislo(), new Attributes(personAttr.getHmotnosti(), personAttr.getVyska())));
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        this.personAttrService.deleteById(id);
    }

    @PutMapping("/{id}")
    public PersonAttrType update(
            @PathVariable("id") Long id,
            @RequestBody IncomingPersonAttr doc
    ) {
        return this.personAttrService.update(id,
                new PersonAttrType(doc.getRodCislo(), new Attributes(doc.getHmotnosti(), doc.getVyska())));
    }
}
