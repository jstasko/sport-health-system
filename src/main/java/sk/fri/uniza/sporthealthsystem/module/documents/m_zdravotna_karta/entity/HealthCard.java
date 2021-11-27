package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthCard {
    private Long id;
    private List<Sickness> sicknesses;
    private String rodCislo;
    private int zdravotnyZaznam;
    private String kontraindikacie;
    private Instant datum_zalozenia;

    public HealthCard(String rodCislo ,int zdravotnyZaznam, String kontraindikacie) {
        this.rodCislo = rodCislo;
        this.zdravotnyZaznam = zdravotnyZaznam;
        this.kontraindikacie = kontraindikacie;

        this.id = null;
        this.datum_zalozenia = null;
        this.sicknesses = new ArrayList<>();
    }
}
