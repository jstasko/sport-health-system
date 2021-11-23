package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_poistovna")
public class AssuranceDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "NAZOV_POISTOVNE")
    private String nazov;

    @OneToMany()
    @JoinColumn(name = "rod_cislo", referencedColumnName = "ID")
    private Set<PersonDto> persons;
}
