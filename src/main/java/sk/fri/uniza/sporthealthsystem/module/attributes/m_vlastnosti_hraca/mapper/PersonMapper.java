package sk.fri.uniza.sporthealthsystem.module.attributes.m_vlastnosti_hraca.mapper;

import sk.fri.uniza.sporthealthsystem.core.mapper.CoreMapper;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonMapper extends CoreMapper<List<Person>> {
    public PersonMapper() {
        super(new ArrayList<>());
    }

    @Override
    public List<Person> mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
