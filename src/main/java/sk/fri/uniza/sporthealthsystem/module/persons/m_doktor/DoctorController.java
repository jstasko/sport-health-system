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

    private final FileMediaService fileMediaService;

    @Autowired
    public DoctorController(DoctorService doctorService, FileMediaService fileMediaService) {
        super(doctorService);
        this.fileMediaService = fileMediaService;
    }


    @GetMapping("/player/{id}")
    ListingResponse<Doctor> getPlayerDoctors(
            Pageable pageable,
            @PathVariable("id") String id
    ) {
        return service.findAll(pageable);
    }

    @GetMapping()
    ListingResponse<ResponseDoctor> findAll(
            Pageable pageable
    ) {
        ListingResponse<Doctor> response =  service.findAll(pageable);
        List<ResponseDoctor> newResponse = new ArrayList<>();
        response.getData().forEach(i -> {
            ResponseDoctor responseDoctor = new ResponseDoctor();
            responseDoctor.setDownload(this.fileMediaService.buildUploadFile(i.getImage(), false).getFileDownloadUri());
            responseDoctor.setMeno(i.getMeno());
            responseDoctor.setPriezvisko(i.getPriezvisko());
            responseDoctor.setRodCislo(i.getPerson().getRodCislo());
            newResponse.add(responseDoctor);
        });

        ListingResponse<ResponseDoctor> doctors = new ListingResponse<>();
        doctors.setData(newResponse);
        doctors.setCurrentPage(response.getCurrentPage());
        doctors.setTotalPages(response.getTotalPages());
        doctors.setTotalItems(response.getTotalItems());

        return doctors;
    }
}
