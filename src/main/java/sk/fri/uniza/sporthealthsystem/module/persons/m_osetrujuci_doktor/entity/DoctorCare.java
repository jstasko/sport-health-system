package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorCare {
    private Long id;
    private Doctor doctor;
    private Institution institution;
}
