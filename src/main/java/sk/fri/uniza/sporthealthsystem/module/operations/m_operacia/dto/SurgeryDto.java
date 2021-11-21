package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.dto.ApothecaryDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.dto.DrugDto;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_operacia")
public class SurgeryDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "popis")
    private String popis;

    @Column(name = "nazov")
    private String nazov;
}
