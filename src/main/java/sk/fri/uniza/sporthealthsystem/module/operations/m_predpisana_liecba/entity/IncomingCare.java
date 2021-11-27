package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IncomingCare {
    private Long idCard;
    private Long idTreatment;
}
