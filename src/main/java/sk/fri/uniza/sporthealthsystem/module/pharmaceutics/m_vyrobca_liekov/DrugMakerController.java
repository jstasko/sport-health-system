package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.entity.DrugMaker;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.service.DrugMakerService;

@RestController
@RequestMapping("/api/pharmaceutics/makers")
public class DrugMakerController extends CrudController<DrugMaker, Integer, DrugMakerService> {

    @Autowired
    public DrugMakerController(DrugMakerService drugMakerService) {
        super(drugMakerService);
    }
}
