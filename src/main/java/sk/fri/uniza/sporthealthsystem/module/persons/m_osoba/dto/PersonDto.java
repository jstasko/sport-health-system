package sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto.AssuranceDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_osoba")
public class PersonDto {

    @Id
    @Column(name = "rod_cislo")
    private String rodCislo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXTERNEID", referencedColumnName = "ID")
    private PlayerDto externeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "EMAIL")
    private UserDto email;
}
