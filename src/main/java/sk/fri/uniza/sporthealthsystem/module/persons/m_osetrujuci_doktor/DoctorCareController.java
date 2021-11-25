package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.service.DoctorCareService;

@RestController
@RequestMapping("/api/doctors/cares")
public class DoctorCareController extends CrudController<DoctorCare, Long, DoctorCareService> {

    @Autowired
    public DoctorCareController(DoctorCareService doctorCareService) {
        super(doctorCareService);
    }
}
