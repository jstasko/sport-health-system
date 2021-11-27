package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity.Doctor;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorDaoImpl extends CrudDaoImpl<Doctor, DoctorDto, String, DoctorRepository> implements DoctorDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DoctorDaoImpl(DoctorRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Doctor findOne(String id) {
        DoctorDto doctorDto = this.findById(id);
        return this.mapper.map(doctorDto, Doctor.class);
    }

    @Override
    public List<Doctor> findAll() {
        return this.findAllEntities()
                .stream()
                .map(i -> this.mapper.map(i, Doctor.class))
                .collect(Collectors.toList());
    }

    @Override
    public Doctor save(Doctor doc) {
        DoctorDto doctorDto = this.mapper.map(doc, DoctorDto.class);
        DoctorDto newDoctorDto = this.repository.save(doctorDto);
        return this.mapper.map(newDoctorDto, Doctor.class);
    }
}
