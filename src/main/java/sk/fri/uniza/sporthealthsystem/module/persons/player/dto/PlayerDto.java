package sk.fri.uniza.sporthealthsystem.module.persons.player.dto;

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
@Table(name = "m_hrac")
public class PlayerDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "meno")
    private String meno;

    @Column(name = "priezvisko")
    private String priezvisko;
}
