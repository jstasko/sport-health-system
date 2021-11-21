package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.dto.ApothecaryDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto.DistrictDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.dto.DrugMakerDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_adresa")
public class AddressDto {

    @Id
    @Column(name = "PSC")
    private String psc;

    @Column(name = "n_mesta")
    private String n_mesta;

    @Column(name = "cislo_domu")
    private String cislo_domu;

    @ManyToOne
    @JoinColumn(name = "id_okresu", referencedColumnName = "ID")
    private DistrictDto district;

    @OneToMany(mappedBy = "psc")
    private Set<DrugMakerDto> drugMakers;

    @OneToMany(mappedBy = "psc")
    private Set<ApothecaryDto> apothecaries;

    @OneToMany(mappedBy = "psc")
    private Set<InstitutionDto> institutions;
}
