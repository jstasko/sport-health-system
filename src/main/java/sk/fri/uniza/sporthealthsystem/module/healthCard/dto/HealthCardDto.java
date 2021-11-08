package sk.fri.uniza.sporthealthsystem.module.healthCard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import sk.fri.uniza.sporthealthsystem.core.BaseDocumentDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "HEALTH_CARD")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthCardDto extends BaseDocumentDto {
    @Column(name = "BIRTH_DAY")
    private String birthDay;
    @Column(name = "ID_SICKNESS")
    private Long idSickness;
    @Column(name = "KONTRAIDIKACIE")
    private String kontraindikacie;

    @Column(name = "CREATED")
    @CreatedDate
    private Date create;
}
