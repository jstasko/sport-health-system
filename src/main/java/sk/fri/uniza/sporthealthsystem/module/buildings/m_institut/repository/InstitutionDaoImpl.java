package sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto.DocSpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.entity.DocSpecialization;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.dto.InstitutionDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.entity.Institution;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstitutionDaoImpl extends CrudDaoImpl<Institution, InstitutionDto, Integer, InstitutionRepository> implements InstitutionDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public InstitutionDaoImpl(InstitutionRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Institution findOne(Integer id) {
        InstitutionDto institutionDto = this.findById(id);
        return this.mapper.map(institutionDto, Institution.class);
    }

    @Override
    public ListingResponse<Institution> findAll(Pageable pageable) {
        Page<InstitutionDto> page =  this.findAllEntities(pageable);
        List<Institution> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Institution.class))
                .collect(Collectors.toList());

        ListingResponse<Institution> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Institution save(Institution doc) {
        InstitutionDto institutionDto = this.mapper.map(doc, InstitutionDto.class);
        InstitutionDto newInstitutionDto = this.repository.save(institutionDto);
        return this.mapper.map(newInstitutionDto, Institution.class);
    }
}
