package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_specializacia")
public class SpecializationDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "popis")
    private String popis;

    @Column(name = "nazov")
    private String nazov;
}
