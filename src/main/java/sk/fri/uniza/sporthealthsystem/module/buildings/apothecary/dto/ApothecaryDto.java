package sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.dto;

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
@Table(name = "m_lekaren")
public class ApothecaryDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "psc", referencedColumnName = "psc")
    private AddressDto psc;

    @Column(name = "nazov")
    private String nazov;

    @OneToMany(mappedBy = "apothecary")
    private Set<TreatmentDto> treatments;
}
