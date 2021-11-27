package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.IncomingHealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.service.HealthCardService;

@RestController
@RequestMapping("/api/documents/cards")
public class HealthCardController {

    HealthCardService healthCardService;

    @Autowired
    public HealthCardController(HealthCardService healthCardService) {
        this.healthCardService = healthCardService;
    }

    @GetMapping("/{id}")
    public HealthCard findOne(
            @PathVariable("id") Long id
    ) {
        return this.healthCardService.findOne(id);
    }

    @PostMapping()
    public HealthCard save(
            @RequestBody IncomingHealthCard incomingHealthCard
            ) {
        return this.healthCardService.save(new HealthCard());
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        this.healthCardService.deleteById(id);
    }

    @PutMapping("/{id}")
    public HealthCard update(
            @PathVariable("id") Long id,
            @RequestBody IncomingHealthCard doc
    ) {
        return this.healthCardService.update(id,new HealthCard());
    }
}
