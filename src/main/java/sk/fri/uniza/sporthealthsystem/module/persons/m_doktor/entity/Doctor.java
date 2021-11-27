package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    private String id;
    private Person person;
    private String meno;
    private String priezvisko;
    private DBFile image;

}
