package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Specialization {
    private Integer id;
    private String nazov;
    private String popis;
}
