package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Surgery {
    private Integer id;
    private String nazov;
    private String popis;
}
