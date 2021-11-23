package sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.exception.NotSaveException;
import sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity.PersonAttrType;

@Component
public class PersonAttrDaoImpl implements PersonAttrDao {

    private final PersonAttrProcedure<Long> personAttrProcedure;

    @Autowired
    public PersonAttrDaoImpl(
            PersonAttrProcedure<Long> personAttrProcedure
    ) {
        this.personAttrProcedure = personAttrProcedure;
    }

    public PersonAttrType findOne(Long id) {
        return personAttrProcedure.getOne(id);
    }

    @Override
    public PersonAttrType save(PersonAttrType doc) throws NotSaveException {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_rod_cislo", doc.getRodCislo())
                .addValue("in_hmotnosti", doc.getAttributes().getHmotnosti())
                .addValue("in_vyska", doc.getAttributes().getVyska());

        PersonAttrType type = this.personAttrProcedure.store(in);
        doc.setId(type.getId());
        return doc;
    }

    @Override
    public void deleteById(Long id) {
        this.personAttrProcedure.deleteById(id);
    }

    @Override
    public PersonAttrType update(Long id, PersonAttrType doc) {
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("in_id", id)
                .addValue("in_rod_cislo", doc.getRodCislo())
                .addValue("in_hmotnosti", doc.getAttributes().getHmotnosti())
                .addValue("in_vyska", doc.getAttributes().getVyska());

        this.personAttrProcedure.update(in);
        return doc;
    }
}
