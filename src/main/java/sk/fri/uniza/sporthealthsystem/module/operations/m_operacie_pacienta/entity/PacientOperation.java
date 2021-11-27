package sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.entity.Person;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacientOperation {
    private Long id;
    private Person person;
    private DoctorCare doctorCare;
    private Surgery surgery;
    private String popis;
}
