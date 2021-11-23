package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Assurance {
    private Integer id;
    private Address nazov;
    private Set<PersonDto> persons;
}
