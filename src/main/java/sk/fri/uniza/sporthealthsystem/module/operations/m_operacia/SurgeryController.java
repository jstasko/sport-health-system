package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.service.SurgeryService;

@RestController
@RequestMapping("/api/operations/surgeries")
public class SurgeryController extends CrudController<Surgery, String, SurgeryService> {

    @Autowired
    public SurgeryController(SurgeryService surgeryService) {
        super(surgeryService);
    }
}
