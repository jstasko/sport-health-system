package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity.Treatment;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.service.TreatmentService;

@RestController
@RequestMapping("/api/operations/treatments")
public class TreatmentController extends CrudController<Treatment, Integer, TreatmentService> {

    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        super(treatmentService);
    }
}
