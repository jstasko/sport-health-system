package sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity.Care;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.entity.IncomingCare;
import sk.fri.uniza.sporthealthsystem.module.operations.m_predpisana_liecba.service.CareService;

@RestController
@RequestMapping("/api/operations/care")
public class CareController {

    CareService careService;

    @Autowired
    public CareController(CareService careService) {
        this.careService = careService;
    }

    @GetMapping("/{id}")
    public Care findOne(
            @PathVariable("id") Long id
    ) {
        return this.careService.findOne(id);
    }

    @PostMapping()
    public Care save(
            @RequestBody IncomingCare incomingCare
            ) {
        return this.careService.save(new Care(incomingCare.getIdCard(), incomingCare.getIdTreatment()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        this.careService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Care update(
            @PathVariable("id") Long id,
            @RequestBody IncomingCare doc
    ) {
        return this.careService.update(id,new Care(doc.getIdCard(), doc.getIdTreatment()));
    }
}
