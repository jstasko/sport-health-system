package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity.District;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    private String psc;
    private String n_mesta;
    private String cislo_domu;
    private District district;
}
