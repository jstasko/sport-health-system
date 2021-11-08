package sk.fri.uniza.sporthealthsystem.module.healthCard;


import org.dozer.loader.api.BeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.module.healthCard.dto.HealthCardDto;
import sk.fri.uniza.sporthealthsystem.module.healthCard.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class HealthCardBeanMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(HealthCard.class, HealthCardDto.class, oneWay())
                .fields("id", "id")
                .fields("birthDay", "birthDay")
                .fields("idSickness", "idSickness")
                .fields("kontraindikacie", "kontraindikacie")
                .fields("create", "create");
        mapping(HealthCardDto.class, HealthCard.class, oneWay())
                .fields("id", "id")
                .fields("birthDay", "birthDay")
                .fields("idSickness", "idSickness")
                .fields("kontraindikacie", "kontraindikacie")
                .fields("create", "create");
    }
}
