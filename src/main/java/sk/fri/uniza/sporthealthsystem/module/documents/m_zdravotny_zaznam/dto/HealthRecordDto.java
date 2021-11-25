package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto.SpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_zdravotny_zaznam")
public class HealthRecordDto {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "stav")
    private String stav;

    @Column(name = "DATUM_PREHLIADKY")
    private Instant datum_prehliadky;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INSTITUT", referencedColumnName = "ID")
    private InstitutionDto institution;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROD_CISLO", referencedColumnName = "ROD_CISLO")
    private PersonDto person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DOKTOR", referencedColumnName = "ID")
    private DoctorDto doctor;
}
