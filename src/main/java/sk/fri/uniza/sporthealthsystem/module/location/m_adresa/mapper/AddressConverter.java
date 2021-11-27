package sk.fri.uniza.sporthealthsystem.module.location.m_adresa.mapper;

import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.dto.AddressDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class AddressConverter extends BeanMappingBuilder {
    @Override
    protected void configure() {

        mapping(Address.class, AddressDto.class, oneWay())
                .fields("psc", "psc")
                .fields("n_mesta", "n_mesta")
                .fields("cislo_domu", "cislo_domu")
                .fields("district", "district");

        mapping(AddressDto.class, Address.class, oneWay())
                .fields("psc", "psc")
                .fields("n_mesta", "n_mesta")
                .fields("cislo_domu", "cislo_domu")
                .fields("district", "district");
    }
}
