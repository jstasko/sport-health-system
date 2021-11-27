package sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.dto.PlayerDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.entity.Player;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.dto.DoctorCareDto;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.entity.DoctorCare;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorCareDaoImpl extends CrudDaoImpl<DoctorCare, DoctorCareDto, Long, DoctorCareRepository> implements DoctorCareDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DoctorCareDaoImpl(DoctorCareRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public DoctorCare findOne(Long id) {
        DoctorCareDto surgeryDto = this.findById(id);
        return this.mapper.map(surgeryDto, DoctorCare.class);
    }

    @Override
    public ListingResponse<DoctorCare> findAll(Pageable pageable) {
        Page<DoctorCareDto> page =  this.findAllEntities(pageable);
        List<DoctorCare> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, DoctorCare.class))
                .collect(Collectors.toList());

        ListingResponse<DoctorCare> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public DoctorCare save(DoctorCare doc) {
        DoctorCareDto surgeryDto = this.mapper.map(doc, DoctorCareDto.class);
        DoctorCareDto newSurgeryDto = this.repository.save(surgeryDto);
        return this.mapper.map(newSurgeryDto, DoctorCare.class);
    }
}
