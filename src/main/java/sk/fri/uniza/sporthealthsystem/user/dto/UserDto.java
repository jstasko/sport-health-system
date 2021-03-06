package sk.fri.uniza.sporthealthsystem.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;
import sk.fri.uniza.sporthealthsystem.user.entity.ERole;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_pouzivatel")
@Entity
public class UserDto {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "heslo")
    private String heslo;

    @Column(name = "datum_posled_prihlasenia")
    private Instant datum_posled_prihlasenia;

    @Column(name = "datum_registracie")
    private Instant datum_registracie;

    @Column(name = "ROLA")
    private String rola;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image", referencedColumnName = "ID")
    private DBFile image;

//    @Enumerated(EnumType.STRING)
//    @Column(length = 20, name = "ROLE")
//    private ERole role;

    @OneToOne(mappedBy = "email")
    private PersonDto person;
}

