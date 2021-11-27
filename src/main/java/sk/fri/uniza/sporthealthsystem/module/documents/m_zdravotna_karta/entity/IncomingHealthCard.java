package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IncomingHealthCard {
    private String rodCislo;
    private List<Sickness> sicknesses;
    private int zdravotnyZaznam;
    private String kontraindikacie;
}
