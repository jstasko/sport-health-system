package sk.fri.uniza.sporthealthsystem.module.healthCard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.healthCard.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.healthCard.service.HealthCardService;

@RestController
@RequestMapping("/api/health-card")
public class HealthCardController extends CrudController<HealthCard, HealthCardService> {
    @Autowired
    public HealthCardController(HealthCardService healthCardService) {
        super(healthCardService);
    }
}
