package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.service.DoctorService;

@RestController
@RequestMapping("/api/persons/persons")
public class DoctorController extends CrudController<Doctor, Long, DoctorService> {

    @Autowired
    public DoctorController(DoctorService doctorService) {
        super(doctorService);
    }
}
