package sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.entity.DrugMaker;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Apothecary {
    private Integer id;
    private Address psc;
    private String nazov;
}
