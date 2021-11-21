package sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Region {
    private String id;
    private String n_kraja;
    private Country country;
}
