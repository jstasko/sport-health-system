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
    private String rodCcislo;
    private List<Sickness> choroba;
    private int zdravotnyZaznam;
    private String kontraindikacie;
    private Instant datum_zalozenia;
}
