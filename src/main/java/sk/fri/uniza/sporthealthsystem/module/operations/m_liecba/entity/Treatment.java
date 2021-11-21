package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
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
