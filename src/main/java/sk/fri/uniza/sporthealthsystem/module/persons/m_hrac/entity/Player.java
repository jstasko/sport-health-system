package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {
    private String id;
    private String meno;
    private String priezvisko;
}
