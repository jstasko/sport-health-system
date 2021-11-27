package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_hrac")
public class PlayerDto {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "meno")
    private String meno;

    @Column(name = "priezvisko")
    private String priezvisko;

    @OneToMany(mappedBy = "externeId")
    private Set<PersonDto> person;
}
