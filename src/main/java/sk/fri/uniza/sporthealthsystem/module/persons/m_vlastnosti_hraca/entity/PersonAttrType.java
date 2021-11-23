package sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonAttrType {
    private Long id;
    private String rodCislo;
    private Attributes attributes;

    public PersonAttrType(String rodCislo, Attributes attributes) {
        this.rodCislo = rodCislo;
        this.attributes = attributes;
    }
}
