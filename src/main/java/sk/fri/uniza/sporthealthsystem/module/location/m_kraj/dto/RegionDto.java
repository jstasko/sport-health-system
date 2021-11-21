package sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto.CountryDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto.DistrictDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_kraj")
public class RegionDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "n_kraja")
    private String n_kraja;

    @ManyToOne
    @JoinColumn(name = "id_krajiny", referencedColumnName = "ID")
    private CountryDto country;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Set<DistrictDto> districts;
}
