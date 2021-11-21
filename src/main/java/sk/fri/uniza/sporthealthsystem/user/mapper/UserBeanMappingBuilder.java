package sk.fri.uniza.sporthealthsystem.user.mapper;


import org.dozer.loader.api.*;
import sk.fri.uniza.sporthealthsystem.core.mapper.InstantConverter;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class UserBeanMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {


        mapping(User.class, UserDto.class, oneWay())
                .fields("email", "email")
                .fields("heslo", "heslo")
                .fields("datum_posled_prihlasenia", "datum_posled_prihlasenia", FieldsMappingOptions.customConverter(InstantConverter.class))
                .fields("datum_registracie", "datum_registracie", FieldsMappingOptions.customConverter(InstantConverter.class))
                .fields("image", "image",FieldsMappingOptions.copyByReference());
        mapping(UserDto.class, User.class, oneWay())
                .fields("email", "email")
                .fields("heslo", "heslo")
                .fields("datum_posled_prihlasenia", "datum_posled_prihlasenia", FieldsMappingOptions.customConverter(InstantConverter.class))
                .fields("datum_registracie", "datum_registracie", FieldsMappingOptions.customConverter(InstantConverter.class))
                .fields("image", "image", FieldsMappingOptions.copyByReference());
    }
}
