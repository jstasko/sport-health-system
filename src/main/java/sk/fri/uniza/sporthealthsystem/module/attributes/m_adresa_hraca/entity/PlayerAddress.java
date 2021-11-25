package sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerAddress {
    private Long id;
    private Address address;
    private Person person;
}
