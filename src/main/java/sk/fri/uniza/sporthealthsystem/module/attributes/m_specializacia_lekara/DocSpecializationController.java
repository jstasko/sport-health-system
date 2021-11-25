package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.entity.DocSpecialization;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.service.DocSpecializationService;

@RestController
@RequestMapping("/api/doctors/specializations/")
public class DocSpecializationController extends CrudController<DocSpecialization, Long, DocSpecializationService> {

    @Autowired
    public DocSpecializationController(DocSpecializationService docSpecializationService) {
        super(docSpecializationService);
    }
}
