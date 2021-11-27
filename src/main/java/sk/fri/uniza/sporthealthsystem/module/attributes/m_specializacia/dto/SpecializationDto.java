package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto.DocSpecializationDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_specializacia")
public class SpecializationDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "popis")
    private String popis;

    @Column(name = "nazov")
    private String nazov;

    @OneToMany(mappedBy = "specialization", fetch = FetchType.EAGER)
    private Set<DocSpecializationDto> specializations;
}
