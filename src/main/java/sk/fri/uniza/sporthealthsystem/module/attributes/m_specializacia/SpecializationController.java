package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.service.SpecializationService;

@RestController
@RequestMapping("/api/operations/specializations")
public class SpecializationController extends CrudController<Specialization, Integer, SpecializationService> {

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        super(specializationService);
    }
}
