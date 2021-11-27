package sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.dto.SpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.entity.Specialization;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.dto.DocSpecializationDto;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.entity.DocSpecialization;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocSpecializationDaoImpl extends CrudDaoImpl<DocSpecialization, DocSpecializationDto, Long, DocSpecializationRepository> implements DocSpecializationDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public DocSpecializationDaoImpl(DocSpecializationRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public DocSpecialization findOne(Long id) {
        DocSpecializationDto surgeryDto = this.findById(id);
        return this.mapper.map(surgeryDto, DocSpecialization.class);
    }

    @Override
    public ListingResponse<DocSpecialization> findAll(Pageable pageable) {
        Page<DocSpecializationDto> page =  this.findAllEntities(pageable);
        List<DocSpecialization> specializations = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, DocSpecialization.class))
                .collect(Collectors.toList());

        ListingResponse<DocSpecialization> listingResponse = new ListingResponse<>();
        listingResponse.setData(specializations);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public DocSpecialization save(DocSpecialization doc) {
        DocSpecializationDto surgeryDto = this.mapper.map(doc, DocSpecializationDto.class);
        DocSpecializationDto newSurgeryDto = this.repository.save(surgeryDto);
        return this.mapper.map(newSurgeryDto, DocSpecialization.class);
    }
}
