package sk.fri.uniza.sporthealthsystem.module.buildings.institution.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;

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

    @ManyToOne
    @JoinColumn(name = "psc", referencedColumnName = "psc")
    private AddressDto psc;

    @Column(name = "nazov")
    private String nazov;

    @Column(name = "popis")
    private String popis;

    @OneToMany(mappedBy = "institution")
    private Set<TreatmentDto> treatments;
}
