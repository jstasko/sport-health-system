package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto.DrugDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_vyrobca_liekov")
public class DrugMakerDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "psc", referencedColumnName = "psc")
    private AddressDto psc;

    @Column(name = "nazov")
    private String nazov;

    @OneToMany(mappedBy = "id_vyrobca_liekov")
    private Set<DrugDto> drugs;
}
