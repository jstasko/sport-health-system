package sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.entity.Drug;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.service.DrugService;

@RestController
@RequestMapping("/api/pharmaceutics/drugs")
public class DrugController extends CrudController<Drug, Integer, DrugService> {

    @Autowired
    public DrugController(DrugService drugService) {
        super(drugService);
    }
}
