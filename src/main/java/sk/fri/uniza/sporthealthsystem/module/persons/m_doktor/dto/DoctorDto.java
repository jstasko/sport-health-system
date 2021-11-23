package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_doktor")
public class DoctorDto {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "meno")
    private String meno;

    @Column(name = "priezvisko")
    private String priezvisko;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image", referencedColumnName = "ID")
    private DBFile image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROD_CISLO", referencedColumnName = "ROD_CISLO")
    private PersonDto person;
}
