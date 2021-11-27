package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocSpecialization {
    private Long id;
    private Specialization specialization;
    private Doctor doc;
}
