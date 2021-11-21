package sk.fri.uniza.sporthealthsystem.module.location.m_krajina.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.dto.RegionDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_krajina")
public class CountryDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "n_krajiny")
    private String n_krajiny;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<RegionDto> regions;
}
