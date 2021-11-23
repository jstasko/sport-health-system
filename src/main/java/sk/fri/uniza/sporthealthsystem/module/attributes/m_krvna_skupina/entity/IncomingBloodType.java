package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IncomingBloodType {
    private String rodCislo;
    private String typSkupiny;
    private String rhFaktor;
}
