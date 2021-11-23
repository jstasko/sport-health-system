package sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.Blood;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.BloodType;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.entity.IncomingBloodType;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_krvna_skupina.service.BloodTypeService;

@RestController
@RequestMapping("/api/operations/blood")
public class BloodTypeController {

    BloodTypeService bloodTypeService;

    @Autowired
    public BloodTypeController(BloodTypeService bloodTypeService) {
        this.bloodTypeService = bloodTypeService;
    }

    @GetMapping("/{id}")
    public BloodType findOne(
            @PathVariable("id") Long id
    ) {
        return this.bloodTypeService.findOne(id);
    }

    @PostMapping()
    public BloodType save(
            @RequestBody IncomingBloodType bloodType
            ) {

        return this.bloodTypeService.save(
                new BloodType(bloodType.getRodCislo(), new Blood(bloodType.getTypSkupiny(), bloodType.getRhFaktor())));
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        this.bloodTypeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public BloodType update(
            @PathVariable("id") Long id,
            @RequestBody IncomingBloodType doc
    ) {
        return this.bloodTypeService.update(id,
                new BloodType(doc.getRodCislo(), new Blood(doc.getTypSkupiny(), doc.getRhFaktor())));
    }
}
