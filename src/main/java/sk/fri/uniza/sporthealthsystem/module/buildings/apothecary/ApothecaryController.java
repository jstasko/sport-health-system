package sk.fri.uniza.sporthealthsystem.module.buildings.apothecary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.entity.Apothecary;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.service.ApothecaryService;

@RestController
@RequestMapping("/api/buildings/apothecaries")
public class ApothecaryController extends CrudController<Apothecary, Integer, ApothecaryService> {

    @Autowired
    public ApothecaryController(ApothecaryService apothecaryService) {
        super(apothecaryService);
    }
}
