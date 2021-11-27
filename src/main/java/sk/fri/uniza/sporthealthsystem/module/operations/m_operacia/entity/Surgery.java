package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Surgery {
    private Integer id;
    private String nazov;
    private String popis;
}
