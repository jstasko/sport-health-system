package sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto.SurgeryDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto.DoctorCareDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_operacie_pacienta")
public class PacientOperationDto {

    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "ROD_CISLO", referencedColumnName = "ROD_CISLO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonDto person;

    @JoinColumn(name = "ID_OPERACIA", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SurgeryDto surgery;

    @JoinColumn(name = "ID_OSETRUJUCI_DOKTOR", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DoctorCareDto doctorCare;

    @Column(name = "POPIS")
    private String popis;
}
