package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.dto.ApothecaryDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto.DrugDto;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_liecba")
public class TreatmentDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cena")
    private double cena;

    @Column(name = "stav")
    private String stav;

    @JoinColumn(name = "ID_LIEK", referencedColumnName = "ID")
    @ManyToOne()
    private DrugDto drug;

    @JoinColumn(name = "ID_LEKAREN", referencedColumnName = "ID")
    @ManyToOne()
    private ApothecaryDto apothecary;

    @JoinColumn(name = "ID_INSTITUT", referencedColumnName = "ID")
    @ManyToOne()
    private InstitutionDto institution;
}
