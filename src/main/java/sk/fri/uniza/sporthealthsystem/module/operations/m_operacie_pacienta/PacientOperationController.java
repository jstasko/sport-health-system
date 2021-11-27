package sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.entity.PacientOperation;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.service.PacientOperationService;

@RestController
@RequestMapping("/api/operations/pacients")
public class PacientOperationController extends CrudController<PacientOperation, Long, PacientOperationService> {

    @Autowired
    public PacientOperationController(PacientOperationService pacientOperationService) {
        super(pacientOperationService);
    }
}
