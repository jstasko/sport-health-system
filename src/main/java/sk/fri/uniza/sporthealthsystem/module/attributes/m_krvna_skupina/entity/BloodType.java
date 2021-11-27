package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BloodType {
    private Long id;
    private String rodCislo;
    private Blood blood;

    public BloodType(String rodCislo, Blood blood) {
        this.rodCislo = rodCislo;
        this.blood = blood;
    }
}
