package sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto.RegionDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto.CountryDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_okres")
public class DistrictDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "n_okresu")
    private String n_okresu;

    @ManyToOne
    @JoinColumn(name = "id_kraja", referencedColumnName = "ID")
    private RegionDto region;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private Set<AddressDto> addresses;
}
