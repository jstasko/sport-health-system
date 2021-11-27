package sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class PlayerConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Player.class, PlayerDto.class, oneWay())
                .fields("id", "id")
                .fields("meno", "meno")
                .fields("priezvisko", "priezvisko");

        mapping(PlayerDto.class, Player.class, oneWay())
                .fields("id", "id")
                .fields("meno", "meno")
                .fields("priezvisko", "priezvisko");
    }
}
