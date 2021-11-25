package sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto.DocSpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_adresa_hraca")
public class PlayerAddressDto {

    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "PSC", referencedColumnName = "PSC")
    @ManyToOne(fetch = FetchType.LAZY)
    private AddressDto address;

    @JoinColumn(name = "ROD_CISLO", referencedColumnName = "ROD_CISLO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonDto person;
}
