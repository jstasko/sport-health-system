package sk.fri.uniza.sporthealthsystem.module.healthCard.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.healthCard.dto.HealthCardDto;
import sk.fri.uniza.sporthealthsystem.module.healthCard.entity.HealthCard;

import java.util.Optional;

@Component
public class HealthCardDaoImpl extends CrudDaoImpl<HealthCard, HealthCardDto, HealthCardRepository> implements HealthCardDao {

    @Autowired
    public HealthCardDaoImpl(HealthCardRepository repository, DozerBeanMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public HealthCard findOne(Long id) {
        Optional<HealthCardDto> found = repository.findById(id);
        return found.map(healthCardDto -> mapper.map(healthCardDto, HealthCard.class)).orElse(null);

    }

    @Override
    public HealthCard save(HealthCard card) {

        HealthCardDto dto = mapper.map(card, HealthCardDto.class);

        HealthCardDto saved = repository.save(dto);
        if (saved.getId() != null) {
            // it's saved if it has an id
            return mapper.map(saved, HealthCard.class);
        }
        return null;
    }
}
