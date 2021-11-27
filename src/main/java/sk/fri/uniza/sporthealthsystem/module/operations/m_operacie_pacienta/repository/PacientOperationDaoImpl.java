package sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto.SurgeryDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.entity.Surgery;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.dto.PacientOperationDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.entity.PacientOperation;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PacientOperationDaoImpl extends CrudDaoImpl<PacientOperation, PacientOperationDto, Long, PacientOperationRepository> implements PacientOperationDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public PacientOperationDaoImpl(PacientOperationRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public PacientOperation findOne(Long id) {
        PacientOperationDto surgeryDto = this.findById(id);
        return this.mapper.map(surgeryDto, PacientOperation.class);
    }

    @Override
    public ListingResponse<PacientOperation> findAll(Pageable pageable) {
        Page<PacientOperationDto> page =  this.findAllEntities(pageable);
        List<PacientOperation> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, PacientOperation.class))
                .collect(Collectors.toList());

        ListingResponse<PacientOperation> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public PacientOperation save(PacientOperation doc) {
        PacientOperationDto surgeryDto = this.mapper.map(doc, PacientOperationDto.class);
        PacientOperationDto newSurgeryDto = this.repository.save(surgeryDto);
        return this.mapper.map(newSurgeryDto, PacientOperation.class);
    }
}
