package sk.fri.uniza.sporthealthsystem.module.healthCard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.fri.uniza.sporthealthsystem.core.CrudServiceImpl;
import sk.fri.uniza.sporthealthsystem.module.healthCard.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.healthCard.repository.HealthCardDao;

@Service
public class HealthCardServiceImpl extends CrudServiceImpl<HealthCard, HealthCardDao> implements HealthCardService {

    @Autowired
    public HealthCardServiceImpl(HealthCardDao dao) {
        super(dao);
    }
}
