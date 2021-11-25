package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity;

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
public class Care {
    private Long id;
    private Long idCard;
    private Long idTreatment;

    public Care(Long idCard, Long idTreatment) {
        this.idCard = idCard;
        this.idTreatment = idTreatment;
    }
}
