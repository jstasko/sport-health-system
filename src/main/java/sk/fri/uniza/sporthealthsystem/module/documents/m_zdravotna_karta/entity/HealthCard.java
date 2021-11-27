package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthCard {
    private Long id;
    private List<Sickness> choroba;
    private int zdravotnyZaznam;
    private String kontraindikacie;
    private Instant datum_zalozenia;

    public HealthCard(List<Sickness> choroba, int zdravotnyZaznam, String kontraindikacie, Instant datum_zalozenia) {
        this.choroba = choroba;
        this.zdravotnyZaznam = zdravotnyZaznam;
        this.kontraindikacie = kontraindikacie;
        this.datum_zalozenia = datum_zalozenia;
    }
}
