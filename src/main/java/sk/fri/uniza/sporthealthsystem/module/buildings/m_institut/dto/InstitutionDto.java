package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto.HealthRecordDto;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto.DoctorCareDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_institut")
public class InstitutionDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "psc", referencedColumnName = "psc")
    private AddressDto psc;

    @Column(name = "nazov")
    private String nazov;

    @Column(name = "popis")
    private String popis;

    @OneToMany(mappedBy = "institution")
    private Set<TreatmentDto> treatments;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HealthRecordDto> healthRecords;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DoctorCareDto> doctorCares;
}
