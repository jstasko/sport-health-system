package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    private String rodCislo;
    private Player externeId;
    private User email;
}
