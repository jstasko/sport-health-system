package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.dto.PacientOperationDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_osetrujuci_doktor")
public class DoctorCareDto {

    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "ID_INSTITUT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private InstitutionDto institution;

    @JoinColumn(name = "ID_DOKTOR", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DoctorDto doctor;

    @OneToMany(mappedBy = "doctorCare", cascade = CascadeType.ALL)
    private Set<PacientOperationDto> pacientOperations;
}
