package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BloodTypeDto {
    @Id()
    private Long id;
    private String rodCislo;
}
