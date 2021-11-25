package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CareDto {
    @Id()
    private Long id;
}
