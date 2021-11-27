package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sickness {
    protected String kod;
    protected String popis;
    protected String nazov;
}
