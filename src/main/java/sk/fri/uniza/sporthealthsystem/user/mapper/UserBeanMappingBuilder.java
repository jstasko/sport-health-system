package sk.fri.uniza.sporthealthsystem.user.mapper;


import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class UserBeanMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(User.class, UserDto.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("firstName", "firstName")
                .fields("lastName", "lastName")
                .fields("title", "title")
                .fields("email", "email")
                .fields("password", "password")
                .fields("username", "username");
        mapping(UserDto.class, User.class, oneWay())
                .fields("id", "id")
                .fields("firstName", "firstName")
                .fields("lastName", "lastName")
                .fields("title", "title")
                .fields("create", "create")
                .fields("email", "email")
                .fields("password", "password")
                .fields("username", "username");
    }
}
