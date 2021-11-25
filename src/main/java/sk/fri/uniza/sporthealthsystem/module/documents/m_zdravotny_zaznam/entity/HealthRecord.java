package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthRecord {
    private Long id;
    private Doctor doctor;
    private Person person;
    private Instant datum_prehliadky;
    private String stav;
    private Institution institution;
}
