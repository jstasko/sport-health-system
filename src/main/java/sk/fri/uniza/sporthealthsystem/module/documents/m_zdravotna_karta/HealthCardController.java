package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.Sickness;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.HealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.IncomingHealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.entity.UpdateHealthCard;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotna_karta.service.HealthCardService;

import java.util.List;

@RestController
@RequestMapping("/api/documents/cards")
public class HealthCardController {

    HealthCardService healthCardService;

    @Autowired
    public HealthCardController(HealthCardService healthCardService) {
        this.healthCardService = healthCardService;
    }

    @GetMapping("/")
    public List<HealthCard> findAll() {
        return this.healthCardService.findAll();
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
        return this.healthCardService.save(new HealthCard(
                incomingHealthCard.getRodCislo(),
                incomingHealthCard.getZdravotnyZaznam(),
                incomingHealthCard.getKontraindikacie()
        ), incomingHealthCard.getSicknesses());
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        this.healthCardService.deleteById(id);
    }

    @DeleteMapping("/{id}/sickness/{sicknessId}")
    public void deleteSicknessById(
            @PathVariable("id") Long id,
            @PathVariable("sicknessId") String sicknessId
    ) {
        this.healthCardService.deleteSicknessById(id, sicknessId);
    }

    @PutMapping("/basic/{id}")
    public HealthCard update(
            @PathVariable("id") Long id,
            @RequestBody UpdateHealthCard doc
    ) {
        return this.healthCardService.update(id,new HealthCard(
               doc.getRodCislo(),
               doc.getZdravotnyZaznam(),
               doc.getKontraindikacie()
        ));
    }

    @PutMapping("/sickness/{id}")
    public HealthCard updateSickness(
            @PathVariable("id") Long id,
            @RequestBody Sickness doc
    ) {
        return this.healthCardService.updateSickness(id,new Sickness(
                doc.getKod(),
                doc.getPopis(),
                doc.getNazov()
        ));
    }
}
