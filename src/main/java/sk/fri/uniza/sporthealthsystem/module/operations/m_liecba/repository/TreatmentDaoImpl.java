package sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.repository;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.core.CrudDaoImpl;
import sk.fri.uniza.sporthealthsystem.core.ListingResponse;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.dto.DistrictDto;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.entity.District;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.dto.TreatmentDto;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.entity.Treatment;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TreatmentDaoImpl extends CrudDaoImpl<Treatment, TreatmentDto, Integer, TreatmentRepository> implements TreatmentDao {

    private final DozerBeanMapper mapper;

    @Autowired
    public TreatmentDaoImpl(TreatmentRepository repository, DozerBeanMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    @Override
    public Treatment findOne(Integer id) {
        TreatmentDto treatmentDto = this.findById(id);
        return this.mapper.map(treatmentDto, Treatment.class);
    }

    @Override
    public ListingResponse<Treatment> findAll(Pageable pageable) {
        Page<TreatmentDto> page =  this.findAllEntities(pageable);
        List<Treatment> data = page.getContent()
                .stream()
                .map(i -> this.mapper.map(i, Treatment.class))
                .collect(Collectors.toList());

        ListingResponse<Treatment> listingResponse = new ListingResponse<>();
        listingResponse.setData(data);
        listingResponse.setTotalItems(page.getTotalElements());
        listingResponse.setTotalPages(page.getTotalPages());
        listingResponse.setCurrentPage(page.getNumber());
        return listingResponse;
    }


    @Override
    public Treatment save(Treatment doc) {
        TreatmentDto treatmentDto = this.mapper.map(doc, TreatmentDto.class);
        TreatmentDto newTreatmentDto = this.repository.save(treatmentDto);
        return this.mapper.map(newTreatmentDto, Treatment.class);
    }
}
