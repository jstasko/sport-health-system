package sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.dto.PlayerAddressDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity.PlayerAddress;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class PlayerAddressConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(PlayerAddress.class, PlayerAddressDto.class, oneWay())
                .fields("id", "id")
                .fields("address", "address")
                .fields("person", "person");

        mapping(PlayerAddressDto.class, PlayerAddress.class, oneWay())
                .fields("id", "id")
                .fields("address", "address")
                .fields("person", "person");
    }
}
