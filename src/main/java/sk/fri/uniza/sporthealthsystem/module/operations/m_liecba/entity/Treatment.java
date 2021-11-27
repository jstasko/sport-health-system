package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Treatment {
    private Integer id;
    private String stav;
    private Double cena;
    private Apothecary apothecary;
    private Drug drug;
    private Institution institution;
}
