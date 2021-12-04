package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.service.FileMediaService;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.ResponseDoctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.service.DoctorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/persons/doctors")
public class DoctorController extends CrudController<Doctor, String, DoctorService> {


    @Autowired
    public DoctorController(DoctorService doctorService, FileMediaService fileMediaService) {
        super(doctorService);
    }


    @GetMapping("/player/{id}")
    ListingResponse<Doctor> getPlayerDoctors(
            Pageable pageable,
            @PathVariable("id") String id
    ) {
        return service.findAll(pageable);
    }

    @GetMapping("/images/all")
    ListingResponse<ResponseDoctor> findAllDoctorsWithImage(
            Pageable pageable
    ) {
        return this.service.findALlWithRodCislo(pageable);
    }

    @GetMapping("/rodCislo/{id}")
    ResponseDoctor findAllDoctorsWithImage(
            @PathVariable("id") String id
    ) {
        return this.service.findOneWithRodCislo(id);
    }
}
