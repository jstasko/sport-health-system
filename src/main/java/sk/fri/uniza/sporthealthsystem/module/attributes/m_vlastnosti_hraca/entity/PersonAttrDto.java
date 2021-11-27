package sk.fri.uniza.sporthealthsystem.module.attributes.m_vlastnosti_hraca.entity;

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
public class PersonAttrDto {
    @Id()
    private Long id;
    private String rodCislo;
}
