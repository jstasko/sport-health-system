package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.service.InstitutionService;

@RestController
@RequestMapping("/api/buildings/institutions")
public class InstitutionController extends CrudController<Institution, Integer, InstitutionService> {

    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        super(institutionService);
    }
}
