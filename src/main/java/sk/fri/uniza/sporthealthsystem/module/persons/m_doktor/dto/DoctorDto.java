package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto.DocSpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto.HealthRecordDto;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto.DoctorCareDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.dto.PersonDto;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_doktor")
public class DoctorDto {

    @Id
    @Column(name = "id")
    private String id;

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

    @OneToMany(mappedBy = "doc", fetch = FetchType.LAZY)
    private Set<DocSpecializationDto> docSpecialization;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<HealthRecordDto> healthRecords;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<DoctorCareDto> doctorCareDtos;
}
