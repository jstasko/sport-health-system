package sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.dto.AssuranceDto;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.entity.Assurance;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.dto.HealthRecordDto;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.entity.HealthRecord;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HealthRecordDaoImpl extends CrudDaoImpl<HealthRecord, HealthRecordDto, Long, HealthRecordRepository> implements HealthRecordDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public HealthRecordDaoImpl(HealthRecordRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public HealthRecord findOne(Long id) {
        HealthRecordDto entity = this.findById(id);
        return this.mapper.map(entity, HealthRecord.class);
    }

    @Override
    public ListingResponse<HealthRecord> findAll(Pageable pageable) {
        Page<HealthRecordDto> page =  this.findAllEntities(pageable);
        List<HealthRecord> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, HealthRecord.class))
                .collect(Collectors.toList());

        ListingResponse<HealthRecord> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }

    @Override
    public HealthRecord save(HealthRecord doc) {
        HealthRecordDto entityDto = this.mapper.map(doc, HealthRecordDto.class);
        HealthRecordDto newEntityDto = this.repository.save(entityDto);
        return this.mapper.map(newEntityDto, HealthRecord.class);
    }
}
