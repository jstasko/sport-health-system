package sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.entity.Assurance;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.service.AssuranceService;

@RestController
@RequestMapping("/api/buildings/assurance")
public class AssuranceController extends CrudController<Assurance, Integer, AssuranceService> {

    @Autowired
    public AssuranceController(AssuranceService assuranceService) {
        super(assuranceService);
    }
}
