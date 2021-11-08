package sk.fri.uniza.sporthealthsystem.module.healthCard.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthCard {
    private Long id;
    private String birthDay;
    private Long idSickness;
    private String kontraindikacie;
    private Date create;

}
