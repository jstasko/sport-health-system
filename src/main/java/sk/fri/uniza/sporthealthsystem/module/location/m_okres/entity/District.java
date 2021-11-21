package sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.entity.Region;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.entity.Country;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class District {
    private String id;
    private String n_okresu;
    private Region region;
}
