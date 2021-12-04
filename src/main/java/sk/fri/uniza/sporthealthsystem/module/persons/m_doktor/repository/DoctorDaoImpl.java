package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.service.FileMediaService;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.ResponseDoctor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorDaoImpl extends CrudDaoImpl<Doctor, DoctorDto, String, DoctorRepository> implements DoctorDao {

    private final DozerBeanMapper mapper;
    private final FileMediaService fileMediaService;
    @Autowired
    public DoctorDaoImpl(DoctorRepository repository, DozerBeanMapper mapper, FileMediaService fileMediaService) {
        super(repository);
        this.mapper = mapper;
        this.fileMediaService = fileMediaService;
    }

    @Override
    public Doctor findOne(String id) {
        DoctorDto doctorDto = this.findById(id);
        return this.mapper.map(doctorDto, Doctor.class);
    }

    @Override
    public ResponseDoctor findOneWithRodCislo(String id) {
        DoctorDto doctorDto = this.findById(id);
        return buildResponse(doctorDto);
    }

    @Override
    public ListingResponse<Doctor> findAll(Pageable pageable) {
        Page<DoctorDto> page =  this.findAllEntities(pageable);
        List<Doctor> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Doctor.class))
                .collect(Collectors.toList());

        ListingResponse<Doctor> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public ListingResponse<ResponseDoctor> findALlWithRodCislo(Pageable pageable) {
        Page<DoctorDto> page = this.findAllEntities(pageable);
        List<DoctorDto> data = page.getContent();

        List<ResponseDoctor> result = new ArrayList<>();

        data.forEach(i -> {
            result.add(buildResponse(i));
        });

        ListingResponse<ResponseDoctor> listingResponse = new ListingResponse<>();
        listingResponse.setData(result);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Doctor save(Doctor doc) {
        DoctorDto doctorDto = this.mapper.map(doc, DoctorDto.class);
        DoctorDto newDoctorDto = this.repository.save(doctorDto);
        return this.mapper.map(newDoctorDto, Doctor.class);
    }

    public ResponseDoctor buildResponse(DoctorDto doctorDto) {
        ResponseDoctor responseDoctor = new ResponseDoctor();
        responseDoctor.setId(doctorDto.getId());
        responseDoctor.setDownload(this.fileMediaService.buildUploadFile(doctorDto.getImage(), false).getFileDownloadUri());
        responseDoctor.setRodCislo(doctorDto.getPerson().getRodCislo());
        responseDoctor.setMeno(doctorDto.getMeno());
        responseDoctor.setPriezvisko(doctorDto.getPriezvisko());
        return responseDoctor;
    }
}
