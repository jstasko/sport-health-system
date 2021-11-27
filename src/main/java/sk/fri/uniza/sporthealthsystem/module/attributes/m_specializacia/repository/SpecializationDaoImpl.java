package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.dto.PlayerAddressDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity.PlayerAddress;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto.SpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecializationDaoImpl extends CrudDaoImpl<Specialization, SpecializationDto, Integer, SpecializationRepository> implements SpecializationDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public SpecializationDaoImpl(SpecializationRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Specialization findOne(Integer id) {
        SpecializationDto surgeryDto = this.findById(id);
        return this.mapper.map(surgeryDto, Specialization.class);
    }

    @Override
    public ListingResponse<Specialization> findAll(Pageable pageable) {
        Page<SpecializationDto> page =  this.findAllEntities(pageable);
        List<Specialization> specializations = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Specialization.class))
                .collect(Collectors.toList());

        ListingResponse<Specialization> listingResponse = new ListingResponse<>();
        listingResponse.setData(specializations);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Specialization save(Specialization doc) {
        SpecializationDto surgeryDto = this.mapper.map(doc, SpecializationDto.class);
        SpecializationDto newSurgeryDto = this.repository.save(surgeryDto);
        return this.mapper.map(newSurgeryDto, Specialization.class);
    }
}
