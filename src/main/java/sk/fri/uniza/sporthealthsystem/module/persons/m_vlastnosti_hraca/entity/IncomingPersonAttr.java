package sk.fri.uniza.sporthealthsystem.module.persons.m_vlastnosti_hraca.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IncomingPersonAttr {
    private String rodCislo;
    private double hmotnosti;
    private double vyska;
}
