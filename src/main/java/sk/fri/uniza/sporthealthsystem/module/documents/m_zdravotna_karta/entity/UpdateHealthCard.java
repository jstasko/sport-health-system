package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateHealthCard {
    private String rodCislo;
    private int zdravotnyZaznam;
    private String kontraindikacie;
}
