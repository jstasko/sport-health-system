package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Institution {
    private Integer id;
    private Address psc;
    private String nazov;
    private String popis;
}
