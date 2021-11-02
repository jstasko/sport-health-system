package sk.fri.uniza.sporthealthsystem.module.healthCard;


import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class HealthCardBeanMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(User.class, UserDto.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit");
        mapping(UserDto.class, User.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit");
    }
}
