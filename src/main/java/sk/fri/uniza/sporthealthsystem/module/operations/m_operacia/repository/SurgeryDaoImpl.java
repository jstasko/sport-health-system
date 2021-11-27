package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity.Treatment;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto.SurgeryDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurgeryDaoImpl extends CrudDaoImpl<Surgery, SurgeryDto, Integer, SurgeryRepository> implements SurgeryDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public SurgeryDaoImpl(SurgeryRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Surgery findOne(Integer id) {
        SurgeryDto surgeryDto = this.findById(id);
        return this.mapper.map(surgeryDto, Surgery.class);
    }

    @Override
    public ListingResponse<Surgery> findAll(Pageable pageable) {
        Page<SurgeryDto> page =  this.findAllEntities(pageable);
        List<Surgery> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Surgery.class))
                .collect(Collectors.toList());

        ListingResponse<Surgery> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public Surgery save(Surgery doc) {
        SurgeryDto surgeryDto = this.mapper.map(doc, SurgeryDto.class);
        SurgeryDto newSurgeryDto = this.repository.save(surgeryDto);
        return this.mapper.map(newSurgeryDto, Surgery.class);
    }
}
