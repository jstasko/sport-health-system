package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto.SpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_specializacia_lekara")
public class DocSpecializationDto {

    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "ID_SPECIALIZACIA", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SpecializationDto specialization;

    @JoinColumn(name = "ID_DOKTOR", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DoctorDto doc;
}
