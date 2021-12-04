package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.dto.PlayerAddressDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity.PlayerAddress;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto.AssuranceDto;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto.HealthRecordDto;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.dto.PacientOperationDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_osoba")
public class PersonDto {

    @Id
    @Column(name = "rod_cislo")
    private String rodCislo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXTERNEID", referencedColumnName = "ID")
    private PlayerDto externeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "EMAIL")
    private UserDto email;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private DoctorDto doctor;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<HealthRecordDto> healthRecords;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PlayerAddressDto playerAddresses;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PacientOperationDto> pacientOperations;
}
