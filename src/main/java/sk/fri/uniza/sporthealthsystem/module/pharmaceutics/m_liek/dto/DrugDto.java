package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.dto.DrugMakerDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_liek")
public class DrugDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_vyrobca_liekov", referencedColumnName = "ID")
    private DrugMakerDto vyrobca_liekov;

    @Column(name = "nazov")
    private String nazov;

    @Column(name = "popis")
    private String popis;

    @OneToMany(mappedBy = "drug")
    private Set<TreatmentDto> treatments;
}
